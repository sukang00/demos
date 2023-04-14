package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/4/14 16:00
 */
@Transactional
@SpringBootTest
@Slf4j
public class SimpleUserRepositoryTest {
    @Autowired
    SimpleUserRepository repository;
    private User user;

    @BeforeEach
    void setUp() {

        user = new User();
        user.setUsername("foobar");
        user.setFirstname("firstname");
        user.setLastname("lastname");
    }

    @Test
    void findSavedUserById() {

        user = repository.save(user);

        assertThat(repository.findById(user.getId())).hasValue(user);
    }

    @Test
    void findSavedUserByLastname() {

        user = repository.save(user);

        assertThat(repository.findByLastname("lastname")).contains(user);
    }

    @Test
    void findByFirstnameOrLastname() {

        user = repository.save(user);

        assertThat(repository.findByFirstnameOrLastname("lastname")).contains(user);
    }

    @Test
    void useOptionalAsReturnAndParameterType() {

        assertThat(repository.findByUsername(Optional.of("foobar"))).isEmpty();

        repository.save(user);

        assertThat(repository.findByUsername(Optional.of("foobar"))).isPresent();
    }

    @Test
    void removeByLastname() {

        // create a 2nd user with the same lastname as user
        User user2 = new User();
        user2.setLastname(user.getLastname());

        // create a 3rd user as control group
        User user3 = new User();
        user3.setLastname("no-positive-match");

        repository.saveAll(Arrays.asList(user, user2, user3));

        assertThat(repository.removeByLastname(user.getLastname())).isEqualTo(2L);
        assertThat(repository.existsById(user3.getId())).isTrue();
    }

    @Test
    void useSliceToLoadContent() {

        repository.deleteAll();

        // int repository with some values that can be ordered
        Integer totalNumberUsers = 11;
        List<User> source = new ArrayList<>(totalNumberUsers);

        for (int i = 1; i <= totalNumberUsers; i++) {

            User user = new User();
            user.setLastname(this.user.getLastname());
            user.setUsername(user.getLastname() + "-" + String.format("%03d", i));
            source.add(user);
        }

        repository.saveAll(source);

        repository.findByLastnameOrderByUsernameAsc(this.user.getLastname(), PageRequest.of(1, 5));

        assertThat(repository.findByLastnameOrderByUsernameAsc(this.user.getLastname(), PageRequest.of(1, 5))).containsAll(source.subList(5, 10));
    }

    @Test
    void findFirst2ByOrderByLastnameAsc() {

        User user0 = new User();
        user0.setLastname("lastname-0");

        User user1 = new User();
        user1.setLastname("lastname-1");

        User user2 = new User();
        user2.setLastname("lastname-2");

        // we deliberately save the items in reverse
        repository.saveAll(Arrays.asList(user2, user1, user0));

        List<User> result = repository.findFirst2ByOrderByLastnameAsc();

        assertThat(result).containsExactly(user0, user1);
    }

    @Test
    void findTop2ByWithSort() {

        User user0 = new User();
        user0.setLastname("lastname-0");

        User user1 = new User();
        user1.setLastname("lastname-1");

        User user2 = new User();
        user2.setLastname("lastname-2");

        // we deliberately save the items in reverse
        repository.saveAll(Arrays.asList(user2, user1, user0));

        List<User> resultAsc = repository.findTop2By(Sort.by(ASC, "lastname"));

        assertThat(resultAsc).containsExactly(user0, user1);

        List<User> resultDesc = repository.findTop2By(Sort.by(DESC, "lastname"));

        assertThat(resultDesc).containsExactly(user2, user1);
    }

    @Test
    void findByFirstnameOrLastnameUsingSpEL() {

        User first = new User();
        first.setLastname("lastname");

        User second = new User();
        second.setFirstname("firstname");

        User third = new User();

        repository.saveAll(Arrays.asList(first, second, third));

        User reference = new User();
        reference.setFirstname("firstname");
        reference.setLastname("lastname");

        List<User> users = (List<User>) repository.findByFirstnameOrLastname(reference);

        assertThat(users).containsExactly(first, second);
    }

    /**
     * Streaming data from the store by using a repository method that returns a {@link Stream}. Note, that since the
     * resulting {@link Stream} contains state it needs to be closed explicitly after use!
     */
    @Test
    void useJava8StreamsWithCustomQuery() {

        User user1 = repository.save(new User("Customer1", "Foo"));
        User user2 = repository.save(new User("Customer2", "Bar"));

        try (Stream<User> stream = repository.streamAllCustomers()) {
            assertThat(stream.collect(Collectors.toList())).contains(user1, user2);
        }
    }

    /**
     * Streaming data from the store by using a repository method that returns a {@link Stream} with a derived query.
     * Note, that since the resulting {@link Stream} contains state it needs to be closed explicitly after use!
     */
    @Test
    void useJava8StreamsWithDerivedQuery() {

        User user1 = repository.save(new User("Customer1", "Foo"));
        User user2 = repository.save(new User("Customer2", "Bar"));

        try (Stream<User> stream = repository.findAllByLastnameIsNotNull()) {
            assertThat(stream.collect(Collectors.toList())).contains(user1, user2);
        }
    }

    /**
     * Query methods using streaming need to be used inside a surrounding transaction to keep the connection open while
     * the stream is consumed. We simulate that not being the case by actively disabling the transaction here.
     */
    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void rejectsStreamExecutionIfNoSurroundingTransactionActive() {
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class, () -> {
            repository.findAllByLastnameIsNotNull();
        });
    }

    /**
     * Here we demonstrate the usage of {@link CompletableFuture} as a result wrapper for asynchronous repository query
     * methods. Note, that we need to disable the surrounding transaction to be able to asynchronously read the written
     * data from another thread within the same test method.
     */
    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void supportsCompletableFuturesAsReturnTypeWrapper() throws Exception {

        repository.save(new User("Customer1", "Foo"));
        repository.save(new User("Customer2", "Bar"));

        CompletableFuture<Void> future = repository.readAllBy().thenAccept(users -> {

            assertThat(users).hasSize(2);
            users.forEach(customer -> log.info(customer.toString()));
            log.info("Completed!");
        });

        while (!future.isDone()) {
            log.info("Waiting for the CompletableFuture to finish...");
            TimeUnit.MILLISECONDS.sleep(500);
        }

        future.get();

        log.info("Done!");

        repository.deleteAll();
    }
}

package com.example.service;

import com.example.entity.User;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/10/28 13:51
 */
@ApplicationScoped
public class UserService {

    @Inject
    EntityManager entityManager;

    @ConfigProperty(name = "greeting.message")
    String message;
    public List<User> get() {
        System.out.println(message);
        return entityManager.createNamedQuery("User.findAll", User.class)
                .getResultList();
    }
    public User getSingle(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Transactional(rollbackOn = Exception.class)
    public void create(User user) {
        entityManager.persist(user);
    }

    @Transactional(rollbackOn = Exception.class)
    public void update(Integer id, User user) {
        User entity = entityManager.find(User.class, id);

        if (null!=entity) {
            entity.setUserName(user.getUserName());
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public void delete(Integer id) {
        User entity = entityManager.getReference(User.class, id);

        if (null!=entity) {
            entityManager.remove(entity);
        }
    }
}

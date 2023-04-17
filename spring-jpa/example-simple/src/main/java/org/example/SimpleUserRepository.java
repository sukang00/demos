/*
 * Copyright 2013-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

/**
 * 用于 {@link User} 实例的简单存储库界面。该接口用于声明所谓的查询方法，
 *  即检索单个实体或其集合的方法。
 *
 * @author Oliver Gierke
 * @author Thomas Darimont
 * @author Christoph Strobl
 */
public interface SimpleUserRepository extends CrudRepository<User, Long> {

	/**
	 * 查找具有给定用户名的用户。此方法将使用
	 *
	 * @param username
	 * @return
	 */
	User findByTheUsersName(String username);

	/**
	 * Uses {@link Optional} as return and parameter type.
	 *
	 * @param username
	 * @return
	 */
	Optional<User> findByUsername(Optional<String> username);

	/**
	 * 此方法将通过直接从方法名称构造查询来转换为查询，因为没有声明其他查询。
	 *
	 * @param lastname
	 * @return
	 */
	List<User> findByLastname(String lastname);

	/**
	 * 返回具有给定名字的所有用户。此方法将使用在声明的 {@link Query} 注释中声明的查询转换为查询。
	 *
	 * @param firstname
	 * @return
	 */
	@Query("select u from User u where u.firstname = :firstname")
	List<User> findByFirstname(String firstname);

	/**
	 * 返回以名字或姓氏作为给定名称的所有用户。这使得查询到方法关系的重构更加安全，因为方法参数的顺序完全无关紧要。
	 *
	 * @param name
	 * @return
	 */
	@Query("select u from User u where u.firstname = :name or u.lastname = :name")
	List<User> findByFirstnameOrLastname(String name);

	/**
	 * 返回删除的条目总数，因为它们的姓氏与给定的姓氏匹配。
	 *
	 * @param lastname
	 * @return
	 */
	Long removeByLastname(String lastname);

	/**
	 * 返回一个 {@link Slice}，用于计算与给定条件匹配的 {@link Pageable#getPageSize（）} 用户的最大数量
	 *  从 {@link Pageable#getOffset（）} 开始，不事先计算可用元素总数。
	 *
	 * @param lastname
	 * @param page
	 * @return
	 */
	Slice<User> findByLastnameOrderByUsernameAsc(String lastname, Pageable page);

	/**
	 * Return the first 2 users ordered by their lastname asc.
	 *
	 * <pre>
	 * Example for findFirstK / findTopK functionality.
	 * </pre>
	 *
	 * @return
	 */
	List<User> findFirst2ByOrderByLastnameAsc();

	/**
	 * Return the first 2 users ordered by the given {@code sort} definition.
	 *
	 * <pre>
	 * This variant is very flexible because one can ask for the first K results when a ASC ordering
	 * is used as well as for the last K results when a DESC ordering is used.
	 * </pre>
	 *
	 * @param sort
	 * @return
	 */
	List<User> findTop2By(Sort sort);

	/**
	 * Return all the users with the given firstname or lastname. Makes use of SpEL (Spring Expression Language).
	 *
	 * @param user
	 * @return
	 */
	@Query("select u from User u where u.firstname = :#{#user.firstname} or u.lastname = :#{#user.lastname}")
	Iterable<User> findByFirstnameOrLastname(User user);

	/**
	 * Sample default method.
	 *
	 * @param user
	 * @return
	 */
	default List<User> findByLastname(User user) {
		return findByLastname(user == null ? null : user.getLastname());
	}

	/**
	 * 演示对 {@link Stream} 作为具有自定义查询的返回类型的支持的示例方法。查询以流式处理方式执行，这意味着该方法在第一个结果准备就绪后立即返回。
	 *
	 * @return
	 */
	@Query("select u from User u")
	Stream<User> streamAllCustomers();

	/**
	 * Sample method to demonstrate support for {@link Stream} as a return type with a derived query. The query is
	 * executed in a streaming fashion which means that the method returns as soon as the first results are ready.
	 *
	 * @return
	 */
	Stream<User> findAllByLastnameIsNotNull();

	@Async
	CompletableFuture<List<User>> readAllBy();
}

/*
 * Copyright 2015-2021 the original author or authors.
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
package org.projections;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Oliver Gierke
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	/**
	 * 使用投影接口指示要返回的字段。由于投影不使用任何动态
	 * 字段，则查询执行将仅限于投影所需的字段。
	 *
	 * @return
	 */
	Collection<CustomerProjection> findAllProjectedBy();

	/**
	 * When a projection is used that contains dynamic properties (i.e. SpEL expressions in an {@link Value} annotation),
	 * the normal target entity will be loaded but dynamically projected so that the target can be referred to in the
	 * expression.
	 *
	 * @return
	 */
	Collection<CustomerSummary> findAllSummarizedBy();

	/**
	 * 投影接口也可以与手动声明的查询一起使用。确保为匹配的项目设置别名
	 *  投影字段。
	 *
	 * @return
	 */
	@Query("select c.firstname as firstname, c.lastname as lastname from Customer c")
	Collection<CustomerProjection> findsByProjectedColumns();

	/**
	 * 动态传入投影类型（接口或 DTO）。
	 *
	 * @param firstname
	 * @param projection
	 * @return
	 */
	<T> Collection<T> findByFirstname(String firstname, Class<T> projection);

	/**
	 * 单个实体的投影。
	 *
	 * @param id
	 * @return
	 */
	CustomerProjection findProjectedById(Long id);

	/**
	 * 单个实体的动态投影。
	 *
	 * @param id
	 * @param projection
	 * @return
	 */
	<T> T findProjectedById(Long id, Class<T> projection);

	/**
	 * 与分页一起使用的投影。
	 *
	 * @param pageable
	 * @return
	 */
	Page<CustomerProjection> findPagedProjectedBy(Pageable pageable);



	/**
	 * A projection wrapped into an {@link Optional}.
	 *
	 * @param lastname
	 * @return
	 */
	Optional<CustomerProjection> findOptionalProjectionByLastname(String lastname);
}

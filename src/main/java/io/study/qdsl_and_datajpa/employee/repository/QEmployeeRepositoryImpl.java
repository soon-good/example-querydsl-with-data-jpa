package io.study.qdsl_and_datajpa.employee.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.study.qdsl_and_datajpa.employee.Employee;
import io.study.qdsl_and_datajpa.employee.QEmployee;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QEmployeeRepositoryImpl implements QEmployeeRepository{

	private final EntityManager entityManager;

	private final JPAQueryFactory queryFactory;

	@Autowired
	public QEmployeeRepositoryImpl(EntityManager entityManager){
		this.entityManager = entityManager;
		this.queryFactory = new JPAQueryFactory(entityManager);
	}

	public List<Employee> findByAnyNameOrSalary(String name, Double salary){
		return queryFactory.selectFrom(QEmployee.employee)
			.where(QEmployee.employee.name.eq(name)
				.or(QEmployee.employee.salary.eq(salary)))
			.fetch();
	}

}

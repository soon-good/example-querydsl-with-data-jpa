package io.study.qdsl_and_datajpa.employee.repository;

import io.study.qdsl_and_datajpa.employee.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeCustomRepository extends JpaRepository<Employee, Long>, QEmployeeRepository{

	@Query("select e from Employee e where e.id =:id")
	List<Employee> findEmployeesById(@Param("id") Long id);
}

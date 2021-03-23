package io.study.qdsl_and_datajpa.employee.repository;

import io.study.qdsl_and_datajpa.employee.Employee;
import java.util.List;

public interface QEmployeeRepository {
	List<Employee> findByAnyNameOrSalary(String name, Double salary);
}

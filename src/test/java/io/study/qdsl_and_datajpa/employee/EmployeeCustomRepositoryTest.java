package io.study.qdsl_and_datajpa.employee;

import io.study.qdsl_and_datajpa.employee.repository.EmployeeCustomRepository;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class EmployeeCustomRepositoryTest {

	@Autowired
	EmployeeCustomRepository customEmpRepository;

	@Autowired
	EntityManager em;

	@BeforeEach
	void insertData(){
		Employee e1 = new Employee("소방관 #1", 1000D);
		Employee e2 = new Employee("소방관 #2", 2000D);

		customEmpRepository.save(e1);
		customEmpRepository.save(e2);
	}

	@Test
	@DisplayName("커스텀_리포지터리_테스트")
	void 커스텀_리포지터리_테스트(){
		List<Employee> employeeCustom = customEmpRepository.findByAnyNameOrSalary("소방관 #1", 1000D);
		System.out.println(employeeCustom);
	}

}

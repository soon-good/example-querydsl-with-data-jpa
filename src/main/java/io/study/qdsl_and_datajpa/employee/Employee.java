package io.study.qdsl_and_datajpa.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {

	@Id @GeneratedValue
	private Long id;

	@Column(name = "v_name")
	private String name;

	@Column(name = "d_salary")
	private Double salary;

	public Employee(){}

	public Employee(String name, Double salary){
		this.name = name;
		this.salary = salary;
	}
}

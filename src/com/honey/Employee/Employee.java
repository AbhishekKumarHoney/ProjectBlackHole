package com.honey.Employee;

import java.util.HashMap;
import java.util.Map;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private Double salary;

	public Employee(int id, String firstName, String lastName, Double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Double getSalary() {
		return salary;
	}

	public static Map<Integer, Employee> getEmployees() {
		Map<Integer, Employee> empMap = new HashMap<>();
		Employee e1 = new Employee(1, "Ben", "Sand", 123.7);
		Employee e2 = new Employee(1, "Den", "Sand", 423.7);
		Employee e3 = new Employee(1, "Hen", "Sand", 123.7);
		Employee e4 = new Employee(1, "Ren", "Sand", 134.7);
		Employee e5 = new Employee(1, "Gen", "Sand", 1897.7);
		empMap.put(1, e1);
		empMap.put(2, e2);
		empMap.put(3, e3);
		empMap.put(4, e4);
		empMap.put(5, e5);
		return empMap;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ "]";
	}

}
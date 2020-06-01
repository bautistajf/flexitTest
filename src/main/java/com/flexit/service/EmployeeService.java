package com.flexit.service;

import java.util.List;
import java.util.Optional;

import com.flexit.model.Employee;


public interface EmployeeService {

	List<Employee> getEmployeesSortedLastEventDate();
	Optional<Employee> findEmployeeWhoOrganizeNextEvent();
}

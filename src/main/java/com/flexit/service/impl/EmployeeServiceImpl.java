package com.flexit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flexit.model.Employee;
import com.flexit.repository.EmployeeRepository;
import com.flexit.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> getEmployeesSortedLastEventDate() {	
			return employeeRepository.findByOrderByLastEventDateDesc();
	}

	@Override
	public Optional<Employee> findEmployeeWhoOrganizeNextEvent() {
		return employeeRepository.findFirstByOrderByLastEventDateAsc();
	}

}

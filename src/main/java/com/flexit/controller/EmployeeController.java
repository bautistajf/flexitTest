package com.flexit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexit.model.Employee;
import com.flexit.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("employees")
@CrossOrigin(origins = "*")
@Slf4j
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getEmployeesSortedLastEventDate")
	public ResponseEntity<List<Employee>> getEmployeesSortedLastEventDate() {
		return ResponseEntity.ok(employeeService.getEmployeesSortedLastEventDate());
	}

	@GetMapping("/getEmployeeWhoOrganizeNextEvent")
	public ResponseEntity<Employee> findEmployeeWhoOrganizeNextEvent() {
		final Optional<Employee> employee = employeeService.findEmployeeWhoOrganizeNextEvent();
		if (employee.isPresent()) return ResponseEntity.ok(employee.get());
		else return ResponseEntity.notFound().build();
	}

	
}

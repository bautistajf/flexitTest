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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("employees")
@CrossOrigin(origins = "*")
@Slf4j
@Api(value="Employee resource rest endpoint")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	@ApiOperation(value="get the list of all employees sorted by the last event date")
	@GetMapping("/getEmployeesSortedLastEventDate")
	public ResponseEntity<List<Employee>> getEmployeesSortedLastEventDate() {
		return ResponseEntity.ok(employeeService.getEmployeesSortedLastEventDate());
	}

	@ApiOperation(value="get The employee who has to organize the next event")
	@GetMapping("/getEmployeeWhoOrganizeNextEvent")
	public ResponseEntity<Employee> findEmployeeWhoOrganizeNextEvent() {
		final Optional<Employee> employee = employeeService.findEmployeeWhoOrganizeNextEvent();
		if (employee.isPresent()) return ResponseEntity.ok(employee.get());
		else return ResponseEntity.notFound().build();
	}

	
}

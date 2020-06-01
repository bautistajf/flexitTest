package com.flexit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.flexit.model.Employee;
import com.flexit.service.EmployeeService;
import com.flexit.service.impl.EmployeeServiceImpl;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runners.MethodSorters;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = FlexitApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FlexitApplicationTests {

	private final String url = "/employees";

	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;
    
    private String getRootUrl() {
        return "http://localhost:" + port;
    }
	
	
	 @Test
	 public void testgetEmployeeWhoOrganizeNextEvent() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<Employee> response = restTemplate.exchange(getRootUrl() + url + "/getEmployeeWhoOrganizeNextEvent",
		HttpMethod.GET, entity, Employee.class);  
		assertNotNull(response.getBody());
		
		assertEquals(response.getBody().getName(), "Rosa");
	}
	 
	 
	 @Test
	 public void testgetEmployeesSortedLastEventDate() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<Employee[]> response = restTemplate.exchange(getRootUrl() + url + "/getEmployeesSortedLastEventDate",
		HttpMethod.GET, entity, Employee[].class);  
		assertNotNull(response.getBody());
		
		assertEquals(response.getBody().length, 5);
	}


}

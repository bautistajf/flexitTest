package com.flexit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flexit.model.Employee;




@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByOrderByLastEventDateDesc();
    
    Optional<Employee> findFirstByOrderByLastEventDateAsc();
}

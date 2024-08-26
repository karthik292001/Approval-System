package com.example.aprovalsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aprovalsystem.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    
    
}

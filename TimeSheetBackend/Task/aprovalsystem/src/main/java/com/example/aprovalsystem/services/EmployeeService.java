package com.example.aprovalsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aprovalsystem.entities.Employee;
import com.example.aprovalsystem.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository eRepo;
    
    public void addEmp(Employee employee){
        eRepo.save(employee);
    }

//    public String findManager(){
//       Employee emp=erepo.findByRole("manager");
//       return emp.getEname();
//    }
    
    
}

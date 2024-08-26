package com.example.aprovalsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aprovalsystem.entities.Employee;
import com.example.aprovalsystem.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService eServ;
    @PostMapping("/add")
    public String add(@RequestBody Employee e){
        System.out.println("hi");
        eServ.addEmp(e);
        return "Added successfully";
    }

    
    
}

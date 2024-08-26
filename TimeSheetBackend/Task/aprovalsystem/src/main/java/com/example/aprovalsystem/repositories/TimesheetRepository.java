package com.example.aprovalsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aprovalsystem.entities.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet,Long>{

    

    List<Timesheet> findAllByEmpid(Long id);

    List<Timesheet> findAllByEmployeeRole(String string);

   
}

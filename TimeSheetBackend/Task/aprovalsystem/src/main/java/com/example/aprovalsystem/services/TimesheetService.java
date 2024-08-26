package com.example.aprovalsystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aprovalsystem.entities.Employee;
import com.example.aprovalsystem.entities.Timesheet;
import com.example.aprovalsystem.repositories.EmployeeRepository;
import com.example.aprovalsystem.repositories.TimesheetRepository;

@Service
public class TimesheetService {
    @Autowired
    TimesheetRepository tRepo;

    @Autowired
    EmployeeRepository eRepo;

   
    public void addTimesheet(Timesheet t) {
        Employee e = eRepo.findById(t.getEmpid()).orElse(null);
        t.setEmployee(e);
        tRepo.save(t);
    }
  
    public List<Timesheet> getTimeSheet(Long id,String status) {
        List<Timesheet> ts=tRepo.findAllByEmpid(id);
        List<Timesheet> l=new ArrayList<>();
        for(Timesheet t:ts){
            if(t.getLeadStatus().equalsIgnoreCase(status)){
                l.add(t);
            }
        }
        return l;
    }

    
    public List<Timesheet> getFreshersTimeSheet() {
        List<Timesheet> ts= tRepo.findAllByEmployeeRole("fresher");
        List<Timesheet> l=new ArrayList<>();
        for(Timesheet t:ts){
            if(t.getLeadStatus().equalsIgnoreCase("pending")){
                l.add(t);
            }

        }
     
        return l;
    }

    public void updateLeadStatus(long id, String status) {
        Timesheet t = tRepo.findById(id).orElse(null);
        t.setLeadStatus(status);
        tRepo.save(t);
    }


    public List<Timesheet> getAll() {
        return tRepo.findAll();
    }

    public void updateManagerStatus(long id, String status) {
        Timesheet t = tRepo.findById(id).orElse(null);
        t.setManagerStatus(status);
        tRepo.save(t);
    }
    



    public void delete(long id) {
        tRepo.deleteById(id);
    }
}

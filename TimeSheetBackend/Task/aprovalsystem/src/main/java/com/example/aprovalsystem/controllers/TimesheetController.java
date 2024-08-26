package com.example.aprovalsystem.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aprovalsystem.entities.Timesheet;
import com.example.aprovalsystem.services.EmployeeService;
import com.example.aprovalsystem.services.TimesheetService;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {
    @Autowired
    TimesheetService tServ;
    @Autowired
    EmployeeService eserv;

    @PostMapping("/add")
    public String addTimesheet(@RequestBody Timesheet t){
        System.out.println(t);
         tServ.addTimesheet(t);
         return "Added successfully";
    }

    @PostMapping("/viewStatus")
    public List<Timesheet> get(@RequestBody Map<String,String> requestBody){
        Long id= Long.parseLong(requestBody.get("id"));
        String status=requestBody.get("status");
        return tServ.getTimeSheet(id,status);
    }

   
   
    @GetMapping("/allFreshersTimesheet")
    public List<Timesheet> getFreshersTimesheets(){
        return tServ.getFreshersTimeSheet();
    }

    @PostMapping("/updateLeadStatus")
    public String updateLead(@RequestBody Map<String,String> requestBody){
        Long id= Long.parseLong(requestBody.get("id"));
        String status=requestBody.get("status");
        tServ.updateLeadStatus(id,status);
        return "Updated successfully";
    }



    
    @GetMapping("/readAll")
    public List<Timesheet> getTimesheets(){
        return tServ.getAll();
    }
    

    
    @PostMapping("/updateManagerStatus")
    public String updateManager(@RequestParam long id,@RequestParam String status){
        tServ.updateManagerStatus(id,status);
        return "Updated successfully";
    }

    
    
    @PostMapping("/delete")
    public String getTimesheets(@RequestParam long id){
         tServ.delete(id);
         return "Deleted successfully";
    }
    
}

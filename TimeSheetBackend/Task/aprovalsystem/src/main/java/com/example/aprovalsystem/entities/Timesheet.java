package com.example.aprovalsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Timesheet {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String description;
    private int totalhrs;
    private String leadStatus="pending";
    private String managerStatus="pending";
    private Long empid;

    @ManyToOne
    @JoinColumn(name="employee")
    private Employee employee;
    
}

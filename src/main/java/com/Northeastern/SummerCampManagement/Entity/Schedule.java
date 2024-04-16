/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author vrind
 */
@Entity
public class Schedule {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer scheduleId;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    
    
    
    

    //Constructors
    public Schedule() {
    }

    public Schedule( LocalDate date, LocalDateTime startTime, LocalDateTime endTime, String location, List<Activity> activities) {
        
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        
    }
    
    //Getters and Setters

    public Integer getScheduleId() {
        return scheduleId;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

   
    
    
    
}

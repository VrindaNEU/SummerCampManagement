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
import jakarta.persistence.OneToOne;
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
    private String date;
    private String startTime;
    private String endTime;
    private String location;
    
    @OneToOne
    @JoinColumn(name = "activityId")
    private Activity activity;
    
    

    //Constructors
    public Schedule() {
    }

    public Schedule( String date, String startTime, String endTime, String location, List<Activity> activities) {
        
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        
    }
    
    //Getters and Setters

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    
    
    public Integer getScheduleId() {
        return scheduleId;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

   
    
    
    
}

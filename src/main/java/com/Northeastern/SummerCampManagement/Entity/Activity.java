/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author vrind
 */




@Entity
public class Activity {
    
    
    public enum Category{
    sports,
    artsCrafts,
    educational
}

public enum Status{
    open,
    cancelled,
    fullyBooked
}
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer activityId;
    private String activityName;
    private String description;
    private Category category;
    private String ageGroup;
    private Status status;
    
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "activities")
    private Set<Student> students = new HashSet<>();
    
    @OneToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    
    
    
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
    public Status getStatus() {
        return status;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    
    

    public void setStatus(Status status) {
        this.status = status;
    }
    //Constructors
    public Activity() {
    }

    public Activity( String activityName, Status status, String description, Category category, String ageGroup) {
       
        this.activityName = activityName;
        this.description = description;
        this.category = category;
        this.ageGroup = ageGroup;
        this.status = status;
    }
    
    //Getters and Setters
    
    

    public Integer getActivityId() {
        return activityId;
    }

    

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
    
    
    
    
}

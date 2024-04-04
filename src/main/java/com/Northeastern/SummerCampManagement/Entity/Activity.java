/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author vrind
 */

enum Category{
sports,
artsCafts,
educational
}

enum Status{
open,
cancelled,
fullyBooked
}


@Entity
public class Activity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer activityId;
    private String activityName;
    private String description;
    private Category category;
    private String ageGroup;

    //Constructors
    public Activity() {
    }

    public Activity( String activityName, String description, Category category, String ageGroup) {
       
        this.activityName = activityName;
        this.description = description;
        this.category = category;
        this.ageGroup = ageGroup;
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

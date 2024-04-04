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
@Entity
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feedbackId;
    private Integer foodFeedback;
    private Integer staffFeedback;
    private Integer activityFeedback;
    private Integer managementFeedback;
    private String Recommendations;

    //Constructors
    public Feedback() {
    }

    public Feedback( Integer foodFeedback, Integer staffFeedback, Integer activityFeedback, Integer managementFeedback, String Recommendations) {
        
        this.foodFeedback = foodFeedback;
        this.staffFeedback = staffFeedback;
        this.activityFeedback = activityFeedback;
        this.managementFeedback = managementFeedback;
        this.Recommendations = Recommendations;
    }
    
    //Getters and Setters

    public Integer getFeedbackId() {
        return feedbackId;
    }


    public Integer getFoodFeedback() {
        return foodFeedback;
    }

    public void setFoodFeedback(Integer foodFeedback) {
        this.foodFeedback = foodFeedback;
    }

    public Integer getStaffFeedback() {
        return staffFeedback;
    }

    public void setStaffFeedback(Integer staffFeedback) {
        this.staffFeedback = staffFeedback;
    }

    public Integer getActivityFeedback() {
        return activityFeedback;
    }

    public void setActivityFeedback(Integer activityFeedback) {
        this.activityFeedback = activityFeedback;
    }

    public Integer getManagementFeedback() {
        return managementFeedback;
    }

    public void setManagementFeedback(Integer managementFeedback) {
        this.managementFeedback = managementFeedback;
    }

    public String getRecommendations() {
        return Recommendations;
    }

    public void setRecommendations(String Recommendations) {
        this.Recommendations = Recommendations;
    }
    
    
}


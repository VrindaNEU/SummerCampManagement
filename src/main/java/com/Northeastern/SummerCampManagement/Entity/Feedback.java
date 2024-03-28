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
    Integer feedbackId;
    Integer foodFeedback;
    Integer staffFeedback;
    Integer activityFeedback;
    Integer managementFeedback;
    String Recommendations;
    
}

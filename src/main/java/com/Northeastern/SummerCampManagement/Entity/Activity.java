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
    Integer activityId;
    String activityName;
    String description;
    Category category;
    String ageGroup;
    
    
}

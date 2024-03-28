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
    Integer scheduleId;
    LocalDate date;
    LocalDateTime startTime;
    LocalDateTime endTime;
    String location;
    
    @OneToMany
    @JoinColumn(name = "activityId")
    private List<Activity> activities;
}

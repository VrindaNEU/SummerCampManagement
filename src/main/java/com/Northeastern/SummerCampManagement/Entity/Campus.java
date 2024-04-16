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
 * @author HP PC
 */

@Entity
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer campusId;

    public Integer getCampusId() {
        return campusId;
    }
    String name;   
    String location;

    public Campus(String name, String location) {
        this.name = name;
        this.location = location;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}

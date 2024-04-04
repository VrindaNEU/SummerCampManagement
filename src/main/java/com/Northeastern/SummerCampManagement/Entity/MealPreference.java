/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

enum Beverage{
juice,
coke,
}
/**
 *
 * @author vrind
 */
@Entity
public class MealPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer preferenceId;
    private String allergies;
    private String foodPreference;
    private Beverage beveragePreferance;
    private String medicalConditions;

    //Constructors
    public MealPreference() {
    }

    public MealPreference( String allergies, String foodPreference, Beverage beveragePreferance, String medicalConditions) {
       
        this.allergies = allergies;
        this.foodPreference = foodPreference;
        this.beveragePreferance = beveragePreferance;
        this.medicalConditions = medicalConditions;
    }
    
    //Getters and Setters

    public Integer getPreferenceId() {
        return preferenceId;
    }


    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }

    public Beverage getBeveragePreferance() {
        return beveragePreferance;
    }

    public void setBeveragePreferance(Beverage beveragePreferance) {
        this.beveragePreferance = beveragePreferance;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }
    
    
    
    
}

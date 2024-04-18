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
import jakarta.persistence.OneToOne;


/**
 *
 * @author vrind
 */
@Entity
public class MealPreference {
    
    public enum Beverage{
    juice,
    coke,
    }
    
    
    public enum FoodPreference{
    vegetarian,
    nonvegetarian,
    vegan
    }
    
    
    
    
    
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer preferenceId;
    private String allergies;
    private FoodPreference foodPreference;
    private Beverage beveragePreferance;
    private String medicalConditions;
    
     @OneToOne
    @JoinColumn(name = "studentId")
    private Student student;
    

    //Constructors
    public MealPreference() {
    }

    public MealPreference( String allergies, FoodPreference foodPreference, Beverage beveragePreferance, String medicalConditions) {
       
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

    public void setFoodPreference(FoodPreference foodPreference) {
        this.foodPreference = foodPreference;
    }

    public FoodPreference getFoodPreference() {
        return foodPreference;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

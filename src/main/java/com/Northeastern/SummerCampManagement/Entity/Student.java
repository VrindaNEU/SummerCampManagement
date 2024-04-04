/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author vrind
 */

@Entity
public class Student extends AppUser{
    
    
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String address;
    private Integer age;
    private Boolean camper;
    private String campUsername;
    private String campPassword;
    
    //Mappings
    @OneToOne
    @JoinColumn(name = "preferenceId")
    private MealPreference mealPreference;
    
    @OneToOne
    @JoinColumn(name = "feedbackId")
    private Feedback feedback;
    
    @OneToMany
    @JoinColumn(name = "activityId")
    private List<Activity> activities;
    
    
    //Constructors

    public Student() {
    }
    

    public Student(String firstName, String lastName, String email, String contactNumber, String address, Integer age, Boolean camper, MealPreference mealPreference, Feedback feedback, List<Activity> activities, String username, String password, Role role, LocalDate registrationDate) {
        super(username, password, role, registrationDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.age = age;
        this.camper = camper;
        this.mealPreference = mealPreference;
        this.feedback = feedback;
        this.activities = activities;
        this.username = username;
        this.password = password;
        this.role = role;
        this.registrationDate = registrationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getCamper() {
        return camper;
    }

    public void setCamper(Boolean camper) {
        this.camper = camper;
    }

    public MealPreference getMealPreference() {
        return mealPreference;
    }

    public void setMealPreference(MealPreference mealPreference) {
        this.mealPreference = mealPreference;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Integer getUserId() {
        return userId;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    

}

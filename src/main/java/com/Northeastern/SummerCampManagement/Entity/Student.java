/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author vrind
 */



@Entity
public class Student extends AppUser{

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String address;
    private Integer age;

    private String attendance;
    private String grade;
    
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
    
//    @ManyToMany
//    @JoinColumn(name = "activityId")
//    private List<Activity> activities;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentId")
    private Parent parent;

    
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "student_activity",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private Set<Activity> activities = new HashSet<>();
    
   
    
    
    //Constructors

    public Student( String username, String password, Role role, LocalDate registrationDate, String firstName, String lastName, String email, String contactNumber, String address, Integer age) {
        super(username, password, role, registrationDate);
       
        this.username = username;
        this.password = password;
        this.role = role;
        this.registrationDate = registrationDate;
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.age = age;

        
        
    }

    public Student() {
    }
    
    
 //Getters and Setters
    

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

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Boolean getCamper() {
        return camper;
    }

    public void setCamper(Boolean camper) {
        this.camper = camper;
    }

    public String getCampUsername() {
        return campUsername;
    }

    public void setCampUsername(String campUsername) {
        this.campUsername = campUsername;
    }

    public String getCampPassword() {
        return campPassword;
    }

    public void setCampPassword(String campPassword) {
        this.campPassword = campPassword;
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

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
    
 

  
    
    

}

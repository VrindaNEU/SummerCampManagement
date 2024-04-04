/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;

enum Designation {
CampLead,
CampManager,
CampAssistant
}
/**
 *
 * @author vrind
 */

@Entity
public class CampStaff extends AppUser{
    
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private Designation designation;
    private Boolean activeStatus;
    
    //Constructors

    public CampStaff() {
    }

    public CampStaff(String firstName, String lastName, String email, String contactNumber, Designation designation, Boolean activeStatus, String username, String password, Role role, LocalDate registrationDate) {
        super(username, password, role, registrationDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.designation = designation;
        this.activeStatus = activeStatus;
        this.username = username;
        this.password = password;
        this.role = role;
        this.registrationDate = registrationDate;
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

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
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

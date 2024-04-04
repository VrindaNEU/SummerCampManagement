/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;

/**
 *
 * @author vrind
 */
@Entity
public class CampAdmin extends AppUser{
    
    private String email;
    private String contactNumber;

    //Constructor
    public CampAdmin() {
    }

    public CampAdmin(String email, String contactNumber, String username, String password, Role role, LocalDate registrationDate) {
        super(username, password, role, registrationDate);
        this.email = email;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
        this.role = role;
        this.registrationDate = registrationDate;
    }
    
    //Getters and Setters

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

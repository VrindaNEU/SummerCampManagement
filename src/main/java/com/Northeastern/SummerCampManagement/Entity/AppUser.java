/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;


enum Role {
  Parent,
  SchoolAdmin,
  CampAdmin,
  Student,
  CampStaff
}

/**
 *
 * @author vrind
 */
@Entity
public class AppUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer userId;
    String Username;
    String Password;
    Role role;
    LocalDate registrationDate;

    public AppUser() {
    }

    public AppUser(Integer userId, String Username, String Password, Role role, LocalDate registrationDate) {
        this.userId = userId;
        this.Username = Username;
        this.Password = Password;
        this.role = role;
        this.registrationDate = registrationDate;
    }

    public String getPassword() {
        return Password;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Role getRole() {
        return role;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    
    
    
    
    
    
}

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




/**
 *
 * @author vrind
 */
@Entity
public class AppUser {
    
   public enum Role {
  Parent,
  SchoolAdmin,
  CampAdmin,
  Student,
  CampStaff
}
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer userId;
    String username;
    String password;
    Role role;
    LocalDate registrationDate;

    //Constructors 
    
    public AppUser() {
    }
    
    public AppUser(String username, String password, Role role, LocalDate registrationDate) {
       
        this.username = username;
        this.password = password;
        this.role = role;
        this.registrationDate = registrationDate;
    }
    
    //Getters and Setters

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
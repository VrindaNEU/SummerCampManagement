/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Dao;

import com.Northeastern.SummerCampManagement.Entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vrind
 */
public interface ParentRepository extends JpaRepository<Parent, Integer>{
    
}

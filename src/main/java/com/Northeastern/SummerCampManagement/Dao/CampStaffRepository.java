/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Northeastern.SummerCampManagement.Entity.CampStaff;

/**
 *
 * @author vrind
 */
public interface CampStaffRepository extends JpaRepository<CampStaff, Integer>{
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Dao;

import com.Northeastern.SummerCampManagement.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vrind
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{
    
}

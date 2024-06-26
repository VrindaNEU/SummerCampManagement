/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Dao;

import com.Northeastern.SummerCampManagement.Entity.Activity;
import com.Northeastern.SummerCampManagement.Entity.Student;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vrind
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
    Collection<Student> findAllByActivities(Activity activity);
    
}

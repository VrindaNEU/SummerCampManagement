/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Northeastern.SummerCampManagement.Dao.StudentRepository;
import com.Northeastern.SummerCampManagement.Dao.ParentRepository;

/**
 *
 * @author vrind
 */

@Service
public class ParentService {
    
    @Autowired
    ParentRepository parentRepository;
    
    @Autowired
    StudentRepository studentRepository;
    
    
    
    
    
}

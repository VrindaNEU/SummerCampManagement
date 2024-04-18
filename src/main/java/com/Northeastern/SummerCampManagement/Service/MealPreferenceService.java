/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import com.Northeastern.SummerCampManagement.Entity.Student;
import com.Northeastern.SummerCampManagement.Entity.MealPreference;
import java.util.Optional;

import com.Northeastern.SummerCampManagement.Dao.MealPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.Northeastern.SummerCampManagement.Dao.StudentRepository;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 *
 * @author vrind
 */
@Service
public class MealPreferenceService {

@Autowired
MealPreferenceRepository mealPreferenceRepository;

@Autowired
StudentRepository studentRepository;

    // Get Meal Preference By Student Id
    public MealPreference getMealPreferenceByStudentId(Integer userId) throws CustomException {
		
		      Optional<Student> student = this.studentRepository.findById(userId);
		if (!student.isPresent()){
			throw new CustomException("Student not found for id:" + userId);}
                
                MealPreference mealpreference = student.get().getMealPreference();

    return mealpreference;

    }
    
     //ViewAll 
     
     public Collection<MealPreference> getAllMealPreferences() throws CustomException {
		
		     
                      Optional<Collection> mealPreferences = Optional.of(this.mealPreferenceRepository.findAll());
                      
                      
		if (mealPreferences.isEmpty())
			throw new CustomException("No MealPreference Found");
		
		return mealPreferences.get();
	}

   
    // Update Meal Preference by Student Id
    
        public Student updateMealPreferenceByUserId(Integer userId, MealPreference mealPreference) throws CustomException {
		
		      Optional<Student> studentOpt = this.studentRepository.findById(userId);
		if (!studentOpt.isPresent()){
			throw new CustomException("Student not found for id:" + userId);}
                
                
                    Student student = studentOpt.get();
                
                    MealPreference existingPreference = student.getMealPreference();
                    existingPreference.setAllergies(mealPreference.getAllergies());
                    existingPreference.setBeveragePreferance(mealPreference.getBeveragePreferance());
                    existingPreference.setFoodPreference(mealPreference.getFoodPreference());
                    existingPreference.setMedicalConditions(mealPreference.getMedicalConditions());
                    
                    student.setMealPreference(existingPreference);
                    
                    
		
		return this.studentRepository.save(student);
	}
        
        
        
        
		
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

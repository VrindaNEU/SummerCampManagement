/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import com.Northeastern.SummerCampManagement.Dao.ActivityRepository;
import com.Northeastern.SummerCampManagement.Entity.Activity;
import com.Northeastern.SummerCampManagement.Entity.Parent;
import com.Northeastern.SummerCampManagement.Entity.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vrind
 */
@Service
public class ActivityService {
    
    @Autowired
    ActivityRepository activityRepository;
    
    //Create Activity
    
     public Activity addActivity(Activity newActivity) throws CustomException  {
		
		return this.activityRepository.save(newActivity);	
	}
    
    //View All Activities
     
      public Collection<Activity> getAllActivities() throws CustomException {
		
		     
                      Optional<Collection> activities = Optional.of(this.activityRepository.findAll());
                      List emptyList = new ArrayList();
                      
		if (activities.isEmpty()){
                     return emptyList;
                
                }
                else{
                return activities.get();
                
                }
	
	}
      
      //ViewById
     
     public Activity getActivityById(Integer activityId) throws CustomException {
		
		      Optional<Activity> activity = this.activityRepository.findById(activityId);
		if (!activity.isPresent())
			throw new CustomException("Activity not found for id:" + activity);
		
		return activity.get();
	}
      
      
    //Register Student For Activity - done in Student Service
      
     
    
    //View Registered Students For Activity
      
       public Collection<Student> getStudentsByActivityId(Integer activityId) throws CustomException {
		
		      Optional<Activity> activity = this.activityRepository.findById(activityId);
		if (!activity.isPresent())
			throw new CustomException("Activity not found for id:" + activityId);
                
                Set<Student> students = new HashSet<Student>();
                
                students = activity.get().getStudents();
		
		return students;
	}
      
      
      
      
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import com.Northeastern.SummerCampManagement.Dao.ActivityRepository;
import com.Northeastern.SummerCampManagement.Dao.ScheduleRepository;
import com.Northeastern.SummerCampManagement.Dao.StudentRepository;
import com.Northeastern.SummerCampManagement.Entity.Activity;
import com.Northeastern.SummerCampManagement.Entity.Parent;
import com.Northeastern.SummerCampManagement.Entity.Schedule;
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
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    ActivityRepository activityRepository;
    
    
    //Create Schedule
    
     public Schedule addSchedule(Schedule newSchedule) throws CustomException  {
		
		return this.scheduleRepository.save(newSchedule);	
	}
     
     public Schedule addScheduleByActivityId(Schedule newSchedule, Integer activityId) throws CustomException  {
        
		      Optional<Activity> activity = this.activityRepository.findById(activityId);
		if (!activity.isPresent())
			throw new CustomException("Activity not found for id:" + activityId);
                
                newSchedule.setActivity(activity.get());
                
                               
                this.scheduleRepository.save(newSchedule);
  
		return newSchedule;	
	}

     
     
     
    
    
    //Get Schedules By User Id
     
     public List<Schedule> getScheduleByCamperId(Integer camperId) throws CustomException {
		
		      Optional<Student> camper = this.studentRepository.findById(camperId);
		if (!camper.isPresent())
			throw new CustomException("Camper not found for id:" + camperId);
                
                Set<Activity> activities = new HashSet<>();
                
                activities = camper.get().getActivities();
		
                List<Schedule> schedules = new ArrayList<Schedule>();
                for (Activity activity : activities){
                
                    schedules.add(activity.getSchedule());
                    
                }
                
		return schedules;
	}
     
     
     //Get Schedules for activity by camperid
     
     public Collection<Schedule> getSchedulesForUserById(Integer camperId) throws CustomException{
           Optional<Student> student = this.studentRepository.findById(camperId);
		if (!student.isPresent())
	    throw new CustomException("Student not found for id:" + camperId);
                
                Set<Activity> activities = new HashSet<Activity>();
                activities =  student.get().getActivities();
                
                List<Schedule> schedules = new ArrayList<Schedule>();
                
                for(Activity activityi : activities){
                schedules.add(activityi.getSchedule());
                    
                }
                System.out.println(schedules.get(0).getDate());
                
                
                return schedules;
     
     }
    
}

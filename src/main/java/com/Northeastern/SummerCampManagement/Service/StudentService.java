/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import com.Northeastern.SummerCampManagement.Entity.Student;
import com.Northeastern.SummerCampManagement.Entity.MealPreference;
import com.Northeastern.SummerCampManagement.Entity.Activity;
import com.Northeastern.SummerCampManagement.Entity.Feedback;
import com.Northeastern.SummerCampManagement.Dao.StudentRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vrind
 */
@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;
    
    // Create Student
    public Student addStudent(Student newStudent) throws CustomException  {
		
		return this.studentRepository.save(newStudent);	
	}
    
    
    // Get Student By Id
    
    public Student getStudentById(Integer userId) throws CustomException {
		
		      Optional<Student> student = this.studentRepository.findById(userId);
		if (!student.isPresent())
			throw new CustomException("Student not found for id:" + userId);
		
		return student.get();
	}
    
    // Update Student(School) By Id
    
    public Student updateStudentById(Integer userId, Student updatedStudent) throws CustomException {
		
		      Optional<Student> studentOpt = this.studentRepository.findById(userId);
		if (!studentOpt.isPresent()){
			throw new CustomException("Student not found for id:" + userId);}
                
                
                    Student student = studentOpt.get();
                
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setContactNumber(updatedStudent.getContactNumber());
                    student.setAddress(updatedStudent.getAddress());
                    student.setAge(updatedStudent.getAge());
                    student.setAttendance(updatedStudent.getAttendance());
                    student.setGrade(updatedStudent.getGrade());
                   
		
		return this.studentRepository.save(student);
	}
    
    // Delete
    
    public String deleteStudentById (Integer userId) throws CustomException{
    
         Optional<Student> student = this.studentRepository.findById(userId);
		if (!student.isPresent())
			throw new CustomException("Student not found for id:" + userId);
         
        this.studentRepository.deleteById(userId);
        
        
    return "Student Deleted Succesfully";
    }
    
    
           //Add Camper By Id
    
     public Student campRegister(Integer userId, String Username, String Password, MealPreference mealpreference) throws CustomException {
		
		      Optional<Student> studentOpt = this.studentRepository.findById(userId);
		if (!studentOpt.isPresent()){
			throw new CustomException("Student not found for id:" + userId);}
                
                    Student student = studentOpt.get();
                
                    student.setCamper(true);
                    student.setCampUsername(Username);
                    student.setCampPassword(Password);
                    student.setMealPreference(mealpreference);
                    
		return this.studentRepository.save(student);
	}
     
     
     //Add feedback
     
     public String addFeedback(Integer userId, Feedback feedback) throws CustomException{
     
          Optional<Student> studentOpt = this.studentRepository.findById(userId);
		if (!studentOpt.isPresent()){
			throw new CustomException("Student not found for id:" + userId);}
                
                    Student student = studentOpt.get();
                    
                    student.setFeedback(feedback);
                    
                     studentRepository.save(student);
     
    
     return "Feedback Added";
     }
     
     
     //Register Activity
     
          public String registerActivity(Integer userId, Activity activity) throws CustomException{
     
          Optional<Student> studentOpt = this.studentRepository.findById(userId);
		if (!studentOpt.isPresent()){
			throw new CustomException("Student not found for id:" + userId);}
                
                    Student student = studentOpt.get();
                    
                   ArrayList<Activity> activities = new ArrayList<>();
                   activities.add(activity);
                    student.setActivities(activities);
                    
                    studentRepository.save(student);
     
    
     return "Registered for Activity";
     }
       
    
    


    
}

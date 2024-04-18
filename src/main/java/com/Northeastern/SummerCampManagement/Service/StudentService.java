/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import com.Northeastern.SummerCampManagement.Dao.MealPreferenceRepository;
import com.Northeastern.SummerCampManagement.Dao.ParentRepository;
import com.Northeastern.SummerCampManagement.Entity.Student;
import com.Northeastern.SummerCampManagement.Entity.MealPreference;
import com.Northeastern.SummerCampManagement.Entity.Activity;
import com.Northeastern.SummerCampManagement.Entity.Feedback;
import com.Northeastern.SummerCampManagement.Dao.StudentRepository;
import com.Northeastern.SummerCampManagement.Entity.Parent;
import com.Northeastern.SummerCampManagement.Entity.SchoolAdmin;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
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
    
    @Autowired
    ParentRepository parentRepository;
    
    @Autowired
    MealPreferenceRepository mealPreferenceRepository;
    
    // Create Student
    public Student addStudentByParentId(Student newStudent, Integer parentId) throws CustomException  {
        
		      Optional<Parent> parent = this.parentRepository.findById(parentId);
		if (!parent.isPresent())
			throw new CustomException("Parent not found for id:" + parentId);
                
                newStudent.setCamper(Boolean.FALSE);
                
                //Adding attendance and Grades
                Random random = new Random();

                // Generate a random number between 1 and 100 (inclusive)
                int randomNumber = random.nextInt(100) + 1;
                
                newStudent.setAttendance(String.valueOf(random));
                newStudent.setGrade(String.valueOf(random));

                //////////////////
                
                newStudent.setParent(parent.get());
                this.studentRepository.save(newStudent);
                
//                List<Student> students = new ArrayList();
//                
//                parent.get().setStudent(students);
//                
//                this.parentRepository.save(parent.get());
//                
		
		return newStudent;	
	}
    
    
    // Get Student By Id
    
    public Student getStudentById(Integer userId) throws CustomException {
		
		      Optional<Student> student = this.studentRepository.findById(userId);
		if (!student.isPresent())
			throw new CustomException("Student not found for id:" + userId);
		
		return student.get();
                
                
	}
    
    //Get All Students
    
    
     
     public Collection<Student> getAllStudents() throws CustomException {
		
		     
                      Optional<Collection> students = Optional.of(this.studentRepository.findAll());
                      
                      
		if (students.isEmpty())
			throw new CustomException("No Students Found");
		
		return students.get();
	}
     
     
     // Get Students by ParentId
     
     
     
     public Collection<Student> getStudentByParentId(Integer parentId) throws CustomException{
     
      Optional<Parent> parent = this.parentRepository.findById(parentId);
		if (!parent.isPresent()){
			throw new CustomException("Parent not found for id:" + parentId);}
                

                   Optional<Collection<Student>> collectStudents = Optional.of(parent.get().getStudent());
                
                 if (!collectStudents.isPresent()){
                       List emptyList = new ArrayList();
			return emptyList;
                  }
                 
                 else{
                 return collectStudents.get();
                 }
     
     }
     
     // loginForCamper
        public  Student loginByCamperId(String userName,String password) throws CustomException{
          Student selectedCamper = new Student();
        List<Student> camperLogin = new ArrayList<Student>();
        camperLogin = (List<Student>)getAllStudents();

        for (Student camperi: camperLogin){
                    if(camperi.getCampUsername().equals(userName) && camperi.getCampPassword().equals(password) && camperi.getCamper().equals(true)){
                        
                       selectedCamper=  camperi;
                       break;
                    }
                  }
     
     return selectedCamper;
     }
        
        //Get all Campers
         public  List<Student> getAllCampers() throws CustomException{
         
        List<Student> students = new ArrayList<Student>();
         students = this.studentRepository.findAll();
         
         
         List<Student> campers = new ArrayList<Student>();

        for (Student camperi: students){
                    if( camperi.getCamper().equals(true)){
                        
                       campers.add(camperi);
                    }
                  }
     
     return campers;
     }
        
        ///
         
         
      public Student  loginByStudentId(String userName,String password) throws CustomException{
     
     Student selectedStudent = new Student();
     List<Student> studentLogin = new ArrayList<Student>();
     studentLogin = (List<Student>)getAllStudents();
        
     for (Student studenti: studentLogin){
                    if(studenti.getUsername().equals(userName) && studenti.getPassword().equals(password)){
                        
                       selectedStudent=  studenti;
                       break;
                    }
                  }
     
     return selectedStudent;
     }
    
    
    
    // Update Student(School) By Id
    
    public Student updateStudentById(Integer userId, Student updatedStudent) throws CustomException {
		
		      Optional<Student> studentOpt = this.studentRepository.findById(userId);
		if (!studentOpt.isPresent()){
			throw new CustomException("Student not found for id:" + userId);}
                
                
                    Student student = studentOpt.get();
                
                   
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
                    student.setRegistrationDate(LocalDate.now());
                    
                    mealpreference.setStudent(student);
                    
                   MealPreference savedPref = this.mealPreferenceRepository.save(mealpreference);
                  
                   student.setMealPreference(savedPref);
                   
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
                    
                   Set<Activity> activities = new HashSet<>();
                   activities.add(activity);
                    student.setActivities(activities);
                    
                    studentRepository.save(student);
     
    
     return "Registered for Activity";
     }
       
     
    


    
}

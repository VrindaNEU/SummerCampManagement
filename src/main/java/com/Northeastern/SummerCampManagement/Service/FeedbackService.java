/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import com.Northeastern.SummerCampManagement.Dao.FeedbackRepository;
import com.Northeastern.SummerCampManagement.Dao.StudentRepository;
import com.Northeastern.SummerCampManagement.Entity.Feedback;
import com.Northeastern.SummerCampManagement.Entity.Parent;
import com.Northeastern.SummerCampManagement.Entity.Student;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vrind
 */
@Service
public class FeedbackService {
    
    @Autowired
    FeedbackRepository feedbackRepository;
    
    @Autowired
    StudentRepository studentRepository;
    
    // Add Feedback By StudentId
     public String addFeedbackByStudentId(Integer studentId, Feedback feedback) throws CustomException  {
		
           Optional<Student> student = this.studentRepository.findById(studentId);
           student.get().setFeedback(feedback);
           this.studentRepository.save(student.get());
	   return "Feedback added successfully";	
	}
     
     //Get All feedbacks
     
     public Collection<Feedback> getAllFeedbacks() throws CustomException  {
     
       Optional<Collection> feedbacks = Optional.of(this.feedbackRepository.findAll());
                      
                      
		if (feedbacks.isEmpty())
			throw new CustomException("No Feedbacks Found");
		
		return feedbacks.get();
     
     }
    
    
}

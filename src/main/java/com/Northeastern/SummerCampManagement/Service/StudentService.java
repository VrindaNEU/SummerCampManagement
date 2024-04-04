/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import com.Northeastern.SummerCampManagement.Entity.Student;
import com.Northeastern.SummerCampManagement.Dao.StudentRepository;
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
    
    //
    
    


    
}

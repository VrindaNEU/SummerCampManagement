/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Northeastern.SummerCampManagement.Dao.ParentRepository;
import com.Northeastern.SummerCampManagement.Dao.StudentRepository;
import com.Northeastern.SummerCampManagement.Entity.Parent;
import com.Northeastern.SummerCampManagement.Entity.Student;
import com.Northeastern.SummerCampManagement.Entity.AppUser.Role;
import com.Northeastern.SummerCampManagement.Entity.SchoolAdmin;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


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
   
    
    // Create
    
     public Parent addParent(Parent newParent) throws CustomException  {
		
         
		return this.parentRepository.save(newParent);	
	}
    
    
    //ViewAll - Todo 
     
     public Collection<Parent> getAllParents() throws CustomException {
		
		     
                      Optional<Collection> parents = Optional.of(this.parentRepository.findAll());
                      
                      
		if (parents.isEmpty())
			throw new CustomException("No Parents Found");
		
		return parents.get();
	}
     
     
    
    //ViewById
     
     public Parent getParentById(Integer userId) throws CustomException {
		
		      Optional<Parent> parent = this.parentRepository.findById(userId);
		if (!parent.isPresent())
			throw new CustomException("Parent not found for id:" + userId);
		
		return parent.get();
	}
     
     public Parent  loginByParentId(String userName,String password) throws CustomException{
     
     Parent selectedParent = new Parent();    
     List<Parent> parentLogin = new ArrayList<Parent>();
     parentLogin = (List<Parent>)getAllParents();
     
     
     for (Parent parenti: parentLogin){
                    if(parenti.getUsername().equals(userName) && parenti.getPassword().equals(password)){
                        
                       selectedParent=  parenti;
                       
                       break;
                    }
                  }
     
     return selectedParent;
     }

    
     
     
      //Update
     
     
     public Parent updateParentById(Integer userId, Parent updatedParent) throws CustomException {

		
		      Optional<Parent> parentOpt = this.parentRepository.findById(userId);
		if (!parentOpt.isPresent()){
			throw new CustomException("Parent not found for id:" + userId);}
                
                
                    Parent parent = parentOpt.get();
                

                    parent.setEmail(updatedParent.getEmail());
                    parent.setContactNumber(updatedParent.getContactNumber());
                    parent.setAddress(updatedParent.getAddress());
                   
		
		return this.parentRepository.save(parent);
	}

    //Delete Parent
     
      public String deleteParentById (Integer userId) throws CustomException{
    
         Optional<Parent> parent = this.parentRepository.findById(userId);
		if (!parent.isPresent()){
			throw new CustomException("Parent not found for id:" + userId);}
                

           List<Student> students = new ArrayList<Student>();
           
                   Optional<Collection<Student>> collecStudents = Optional.of(parent.get().getStudent());
                  if (collecStudents.isPresent()){
                 students = parent.get().getStudent();
                  
                  
                  for (Student studenti: students){
                    this.studentRepository.deleteById(studenti.getUserId());
                  }
     
                  }

         
        this.parentRepository.deleteById(userId);
        

        
    return "Parent Deleted Succesfully";
    }

    
    public Parent getParenttById(Integer userId) throws CustomException {
		
		      Optional <Parent> parent = this.parentRepository.findById(userId);
		if (!parent.isPresent())
			throw new CustomException("Parent not found for id:" + userId);
		
		return parent.get();
	}
    
    
    
    
}

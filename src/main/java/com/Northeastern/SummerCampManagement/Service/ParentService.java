/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Northeastern.SummerCampManagement.Dao.ParentRepository;
import com.Northeastern.SummerCampManagement.Entity.Parent;
import java.util.Optional;

/**
 *
 * @author vrind
 */

@Service
public class ParentService {
    
    @Autowired
    ParentRepository parentRepository;
 
    
//    add parent by studentid
    
   
    public Parent addParentBystudentId(Parent newparent) throws CustomException  {
		
		return this.parentRepository.save(newparent);	
	}
    
    //update parent by Id
    public Parent updateParentById(Integer userId, Parent updatedParent) throws CustomException {
		
		      Optional<Parent> parentOpt = this.parentRepository.findById(userId);
		if (!parentOpt.isPresent()){
			throw new CustomException("Parent not found for id:" + userId);}
                
                
                    Parent parent = parentOpt.get();
                
                   parent.setFirstName(updatedParent.getFirstName());
                    parent.setLastName(updatedParent.getLastName());
                    parent.setEmail(updatedParent.getEmail());
                    parent.setContactNumber(updatedParent.getContactNumber());
                    parent.setAddress(updatedParent.getAddress());
                  
		
		return this.parentRepository.save(parent);
	}
    
    // Delete
    
    public String deleteParentById (Integer userId) throws CustomException{
    
         Optional<Parent> parent= this.parentRepository.findById(userId);
		if (!parent.isPresent())
			throw new CustomException("Parent not found for id:" + userId);
         
        this.parentRepository.deleteById(userId);
        
        
    return "Parent Deleted Succesfully";
    }
    
     // Get Parent By Id
    
    public Parent getParenttById(Integer userId) throws CustomException {
		
		      Optional <Parent> parent = this.parentRepository.findById(userId);
		if (!parent.isPresent())
			throw new CustomException("Parent not found for id:" + userId);
		
		return parent.get();
	}
    
    
    
    
}

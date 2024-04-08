/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import com.Northeastern.SummerCampManagement.Dao.CampusRepository;
import com.Northeastern.SummerCampManagement.Entity.Campus;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP PC
 */

@Service
public class CampusService {
    
   @Autowired
   CampusRepository campusRepository;
   
   //Add Campus
   public Campus addCampusByCampusId(Campus newCampus) throws CustomException  {
		
		return this.campusRepository.save(newCampus);	
	}
   
   //Update Campus
       public Campus updateCampusById(Integer userId, Campus updatedCampus) throws CustomException {
		
		Optional<Campus> campusOpt = this.campusRepository.findById(userId);
		if (!campusOpt.isPresent()){
			throw new CustomException("Campus not found for id:" + userId);}
                
                
                Campus campus = campusOpt.get();
                
                campus.setName(updatedCampus.getName());
                campus.setLocation(updatedCampus.getLocation());
                    
                  
		
		return this.campusRepository.save(campus);
	}
    
   
   //Delete Campus
    public String deleteCampusById (Integer userId) throws CustomException{
    
         Optional<Campus> campus= this.campusRepository.findById(userId);
		if (!campus.isPresent())
			throw new CustomException("Campus not found for id:" + userId);
         
        this.campusRepository.deleteById(userId);
        
        
    return "Campus Deleted Succesfully";
    }
    
    //get campus info
    public List<Campus> getAllCampuses(){
               
        return this.campusRepository.findAll();
    }
    
    //get Campus by id
    public Campus getCampusById(Integer campusId) throws CustomException{
               
        Optional<Campus> campus= this.campusRepository.findById(campusId);
		if (!campus.isPresent())
			throw new CustomException("Campus not found for id:" + campusId);
                
        return campus.get();    
    }
    
}

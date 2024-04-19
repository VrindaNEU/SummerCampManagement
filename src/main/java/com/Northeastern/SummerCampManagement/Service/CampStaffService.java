/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import com.Northeastern.SummerCampManagement.Dao.CampStaffRepository;
import com.Northeastern.SummerCampManagement.Entity.CampStaff;
import com.Northeastern.SummerCampManagement.Entity.Parent;
import com.Northeastern.SummerCampManagement.Entity.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vrind
 */

@Service
public class CampStaffService {
    
    @Autowired
    CampStaffRepository campStaffRepository;
    
    
    //Get By Id
    
     public CampStaff getCampStaffById(Integer userId) throws CustomException {
		
		      Optional<CampStaff> campStaff = this.campStaffRepository.findById(userId);
		if (!campStaff.isPresent())
			throw new CustomException("Staff not found for id:" + userId);
		
		return campStaff.get(); 
                
	}

    
    //Get All
     
      public Collection<CampStaff> getAllCampStaff() throws CustomException {
		
		     
                      Optional<Collection> campStaff = Optional.of(this.campStaffRepository.findAll());
                      
                      
		if (campStaff.isEmpty())
			throw new CustomException("No Staff Found");
		
		return campStaff.get();
	}
     
     public CampStaff  loginByCampStaffId(String userName,String password) throws CustomException{
     
        CampStaff selectedCampStaff = new CampStaff();
        List<CampStaff> campStaffLogin = new ArrayList<CampStaff>();
        campStaffLogin = (List<CampStaff>)getAllCampStaff();

        for (CampStaff campStaffi: campStaffLogin){
                    if(campStaffi.getUsername().equals(userName) && campStaffi.getPassword().equals(password)){
                        
                       selectedCampStaff=  campStaffi;
                       break;
                    }
                  }
     
     return selectedCampStaff;
     }
    
    // Create Staff
      
       public CampStaff addCampStaff(CampStaff newStaff) throws CustomException  {
		
		return this.campStaffRepository.save(newStaff);	
	}
      
    
    // Update Staff
       
            public CampStaff updateCampStaffById(Integer userId, CampStaff updatedStaff) throws CustomException {
		
		      Optional<CampStaff> campStaffOpt = this.campStaffRepository.findById(userId);
		if (!campStaffOpt.isPresent()){
			throw new CustomException("Staff not found for id:" + userId);}
                
                
                    CampStaff staff = campStaffOpt.get();
                
                 
                    staff.setEmail(updatedStaff.getEmail());
                    staff.setContactNumber(updatedStaff.getContactNumber());
                    staff.setDesignation(updatedStaff.getDesignation());
                   staff.setActiveStatus(updatedStaff.getActiveStatus());
		
		return this.campStaffRepository.save(staff);
	}
    
    
}

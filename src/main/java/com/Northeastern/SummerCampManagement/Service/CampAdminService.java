/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import com.Northeastern.SummerCampManagement.Dao.CampAdminRepository;
import com.Northeastern.SummerCampManagement.Entity.CampAdmin;
import com.Northeastern.SummerCampManagement.Entity.SchoolAdmin;
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
public class CampAdminService {
    
     @Autowired
    CampAdminRepository campAdminRepository;
    
    //ViewAllAdmin - 
     
     public Collection<CampAdmin> getAllCampAdmins() throws CustomException {
		
		     
                      Optional<Collection> campAdmins = Optional.of(this.campAdminRepository.findAll());
                      
                      
		if (campAdmins.isEmpty())
			throw new CustomException("No Admins Found");
		
		return campAdmins.get();
	}
     
      //Add Admins
     public CampAdmin addCampAdmin(CampAdmin newCampAdmin) throws CustomException  {
		
         
		return this.campAdminRepository.save(newCampAdmin);	
	}
     
    
     public CampAdmin  loginByCampAdminId(String userName,String password) throws CustomException{
     
     CampAdmin selectedCampAdmin = new CampAdmin();
     List<CampAdmin> campAdminLogin = new ArrayList<CampAdmin>();
     campAdminLogin = (List<CampAdmin>)getAllCampAdmins();
     
     for (CampAdmin campAdmini: campAdminLogin){
                    if(campAdmini.getUsername().equals(userName) && campAdmini.getPassword().equals(password)){
                       selectedCampAdmin =  campAdmini;
                       break;
                    }
                  }
     
     return selectedCampAdmin;
     }
    
}

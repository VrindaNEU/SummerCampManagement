/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.Service;

import com.Northeastern.SummerCampManagement.Dao.ParentRepository;
import com.Northeastern.SummerCampManagement.Dao.SchoolAdminRepository;
import com.Northeastern.SummerCampManagement.Entity.Parent;
import com.Northeastern.SummerCampManagement.Entity.SchoolAdmin;
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
public class SchoolAdminService {
    
      @Autowired
    SchoolAdminRepository schoolAdminRepository;
    
    //ViewAllAdmin - 
     
     public Collection<SchoolAdmin> getAllAdmins() throws CustomException {
		
		     
                      Optional<Collection> admins = Optional.of(this.schoolAdminRepository.findAll());
                      
                      
		if (admins.isEmpty())
			throw new CustomException("No Admins Found");
		
		return admins.get();
	}
     public SchoolAdmin addSchoolAdmin(SchoolAdmin newSchoolAdmin) throws CustomException  {
		
         
		return this.schoolAdminRepository.save(newSchoolAdmin);	
	}
     
    
      public SchoolAdmin  loginByAdminId(String userName,String password) throws CustomException{
          
     List<SchoolAdmin> adminLogin = new ArrayList<SchoolAdmin>();
             adminLogin = (List<SchoolAdmin>)getAllAdmins();
     SchoolAdmin selectedAdmin = new SchoolAdmin();
     for (SchoolAdmin admini: adminLogin){
                    if(admini.getUsername()==userName && admini.getPassword()== password){
                        
                       selectedAdmin =  admini;
                       System.out.println(admini.getPassword());
                    }
                  
                  }
       System.out.println(selectedAdmin.getPassword());
     return selectedAdmin;
     }
    
}

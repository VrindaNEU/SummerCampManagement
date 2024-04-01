package com.Northeastern.SummerCampManagement;

import com.Northeastern.SummerCampManagement.Dao.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SummerCampManagementApplication {
@Autowired
ActivityRepository activityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SummerCampManagementApplication.class, args);
                
               
	}

}

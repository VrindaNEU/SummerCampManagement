package com.Northeastern.SummerCampManagement;
import com.Northeastern.SummerCampManagement.Entity.AppUser;
import com.Northeastern.SummerCampManagement.Entity.CampAdmin;
import com.Northeastern.SummerCampManagement.Entity.CampStaff;
import com.Northeastern.SummerCampManagement.Entity.SchoolAdmin;
import com.Northeastern.SummerCampManagement.Service.CustomException;
import com.Northeastern.SummerCampManagement.View.CampMainFrame;
import com.Northeastern.SummerCampManagement.View.SchoolMainFrame;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;



@SpringBootApplication
public class SummerCampManagementApplication {
    
    
    
	
	public static void main(String[] args) {
                
		//SpringApplication.run(SummerCampManagementApplication.class, args);
                
                new SpringApplicationBuilder(SummerCampManagementApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
                
       
                
//               startSchoolApplication();
//              startCampApplication();
           Scanner scanner = new Scanner(System.in);
        System.out.println("Which application do you want to start? (school/camp): ");
        String choice = scanner.nextLine();
 
        switch (choice.toLowerCase()) {
            case "school":
                startSchoolApplication();
                break;
            case "camp":
                startCampApplication();
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                System.exit(1);
        }
                
        
    }
        
        private static void startSchoolApplication() {
        SchoolMainFrame frame = new SchoolMainFrame();

       frame.setSize(700, 700);
       frame.setVisible(true);
    }

        
        private static void startCampApplication() {
        CampMainFrame frame = new CampMainFrame();

       frame.setSize(700, 700);
       frame.setVisible(true);
    }
        
        
        
        
    

}

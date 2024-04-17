package com.Northeastern.SummerCampManagement;
import com.Northeastern.SummerCampManagement.View.SchoolMainFrame;
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
                
                startSchoolApplication();
                
        
    }
        
        private static void startSchoolApplication() {
        SchoolMainFrame frame = new SchoolMainFrame();

       frame.setSize(800, 600);
       frame.setVisible(true);
    }

    

}

/*! \mainpage VolunteeRocks Application
* \section intro_section Introduction
* VolunteeRocks is a web application that allows individuals with certain skill sets to 
* search for and volunteer in nearby locations. Small businesses and others organizations in 
* the community with need for volunteers can submit volunteering opportunities.
* \section run_section Running the application.
* Start the application using the command "mvn spring-boot:run". Open a browser and navigate to
* http://localhost:8080 to run the application and perform the various functions offered. 
*/

package com.example.demo_addFunc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAddFuncApplication {

	/**
	 * Main function for the application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoAddFuncApplication.class, args);
	}

}

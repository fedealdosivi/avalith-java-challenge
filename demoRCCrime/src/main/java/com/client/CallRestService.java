package com.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.model.Crime;

@Component
public class CallRestService implements CommandLineRunner{
	
	private static void callRestService(){
		printAll(getAll());
	}

	/**
	 * Returns a vector of crimes
	 * @return
	 */
	private static Crime [] getAll(){
	
		RestTemplate restTemplate = new RestTemplate();  
		return restTemplate.getForObject("http://NflArrest.com/api/v1/crime/", Crime[].class);

	}

	/**
	 * Prints all crimes from vector
	 * @param crimes
	 */
	private static void printAll(Crime [] crimes){
		// Retrieve all crimes
		System.out.println("Crimen list");
		for (int i = 0; i<crimes.length; i++){
			System.out.println("Arrest count: " + crimes[i].getArrest_count() + " Category: " + crimes[i].getCategory());
		}
	}

	/**
	 * Runs the system
	 * @param args
	 * @throws Exception
	 */
		
	@Override
	public void run(String... args) throws Exception {
		callRestService();
		
	}
	
}

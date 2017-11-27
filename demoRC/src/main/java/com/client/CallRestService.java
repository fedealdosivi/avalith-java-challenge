package com.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.model.Person;

@Component
public class CallRestService implements CommandLineRunner{

	/**
	 * Prints all person from list
	 * Prints person with id given
	 */
	private static void callRestService(String id){
		printAll(getAll());
		printById(getPersonById(id));
	}

	/**
	 * Returns vector of Person
	 * @return Vector of Person
	 */
	private static Person[] getAll(){
		RestTemplate restTemplate = new RestTemplate();  
		return restTemplate.getForObject("http://localhost:8080/persons/", Person[].class);
	}

	/**
	 * Prints all information from Person
	 * @param persons
	 */
	private static void printAll(Person [] persons){
		System.out.println("Persons list");
		for (int i = 0; i<persons.length; i++){
			System.out.println(persons[i].getId()+"Person name is: " + persons[i].getFirsName() + " " + persons[i].getLastName() + " age: "+ persons[i].getAge());
		}
	}

	/**
	 * Returns Person searched by id
	 * @param id
	 * @return Person
	 */
	private static Person getPersonById(String id){
		RestTemplate restTemplate = new RestTemplate();  
		return restTemplate.getForObject("http://localhost:8080/persons/"+ id, Person.class);
	}

	/**
	 * Prints Person searched by id
	 * @param person
	 */
	private static void printById(Person person){
		System.out.println("");
		if (person != null) {
			System.out.println("Person name is: " + person.getFirsName() + " " + person.getLastName() + " age: "+ person.getAge());
		}else
			System.out.println("Person id not found");
	}

	/**
	 * Calls the function to print the persons
	 * Runs the system
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		callRestService("1");
		
	}	
}

package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Person;

@Service
public class PersonService {
	
	List<Person> persons = new ArrayList<Person>(); 
	
	// Instance elements
	public PersonService (){
		Person p = new Person(1,"Juan","Perez",23);
		persons.add(p);
		
		p = new Person(2,"Martin","Gomez",36);
		persons.add(p);
		
		p = new Person(3,"Federico","Lopez",36);
		persons.add(p);
		
		p = new Person(4,"Matias","Corail",36);
		persons.add(p);
		
	}

	/**
	 * Returns person searched by id
	 * @param id
	 * @return Person
	 */
	public Person getPerson(long id) {
		
		// Find person by id
		Iterator<Person> it = persons.iterator();
		while(it.hasNext()) {
			 Person person = it.next();
			 if (person.getId()==id)
				 return person;			 
		}			  		
		return null;
	}

	/**
	 * Returns all person from list
	 * @return ArrayList
	 */
	public List<Person> getAll(){
		return persons;
	}	
}

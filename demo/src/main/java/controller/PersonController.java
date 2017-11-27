package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Person;
import service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	PersonService ps;

	/**
	 * Returns list of person
	 * @return ArrayList
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> getAll(){
		return ps.getAll();
	}

	/**
	 * Returns person searched by id
	 * @param id
	 * @return Person
	 */
	
	@RequestMapping(value="{id}",method = RequestMethod.GET)
	public Person getPerson(@PathVariable("id") long id) {
		return ps.getPerson(id);		
	}
		
}

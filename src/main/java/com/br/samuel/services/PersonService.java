package com.br.samuel.services;


import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.samuel.exceptions.ResourceNotFoundException;
import com.br.samuel.models.Person;
import com.br.samuel.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll(){
		logger.info("Finding all persons!");
		
		return repository.findAll();
	}

	public Person findById(Long id) {
		logger.info("Finding one person!");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating person!");
		
		Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstname(person.getFirstname());
		entity.setLastname(person.getLastname());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Deleting person!");
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}	
}

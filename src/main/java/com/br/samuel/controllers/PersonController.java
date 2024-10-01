package com.br.samuel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.samuel.models.Person;
import com.br.samuel.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;

	
	@GetMapping("/{id}")
	public Person findById(@PathVariable Long id) throws Exception {
		return service.findById(id);
	}
	
	@GetMapping
	public List<Person> findAll() {
		return service.findAll();
	}
	
	@PostMapping("/create")
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
	
	@PutMapping("/update")
	public Person update(@RequestBody Person person) {
		return service.create(person);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

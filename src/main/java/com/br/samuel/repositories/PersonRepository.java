package com.br.samuel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.samuel.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
}

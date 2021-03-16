package org.springframework.petclinicdata.services;

import java.util.Set;

import org.springframework.petclinicdata.model.Pet;

public interface PetService {

	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
}

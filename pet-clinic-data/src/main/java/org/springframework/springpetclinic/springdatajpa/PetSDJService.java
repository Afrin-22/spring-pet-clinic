package org.springframework.springpetclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.springpetclinic.model.Pet;
import org.springframework.springpetclinic.model.PetType;
import org.springframework.springpetclinic.repositories.PetRepository;
import org.springframework.springpetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetSDJService implements PetService{

	private final PetRepository petRepository;
	
	public PetSDJService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

	
}

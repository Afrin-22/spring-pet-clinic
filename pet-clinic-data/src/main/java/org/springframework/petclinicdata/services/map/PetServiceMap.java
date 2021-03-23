package org.springframework.petclinicdata.services.map;

import java.util.Set;

import org.springframework.petclinicdata.model.Pet;
import org.springframework.petclinicdata.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
 
	@Override
	public Pet save(Pet object) {
		return super.save(object.getId(), object);
	}

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}



}

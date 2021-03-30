package org.springframework.springpetclinic.services.map;



import java.util.Set;

import org.springframework.springpetclinic.model.Owner;
import org.springframework.springpetclinic.services.OwnerService;
import org.springframework.springpetclinic.services.PetService;
import org.springframework.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetService petService;
	private final PetTypeService petTypeService;
	
	public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public Owner save(Owner object) {
		
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if(pet.getPetType() != null) {
						if(pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					}
					else
						throw new RuntimeException("Pet Type is required!");
					
					if(pet.getId() == null) {
						petService.save(pet);
					}
				
				});
			}
			
			return super.save(object);
		}
		return null;
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}


}

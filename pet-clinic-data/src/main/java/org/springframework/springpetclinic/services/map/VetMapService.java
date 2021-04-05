package org.springframework.springpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.springpetclinic.model.Vet;
import org.springframework.springpetclinic.services.SpecialityService;
import org.springframework.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;
	
	public VetMapService(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
	public Vet save(Vet object) {
		
		if(object != null) {
			if(object.getSpecialities().size() > 0) {
				object.getSpecialities().forEach(spec -> {
					if(spec.getId() == null) {
						specialityService.save(spec);
					}
				});
			}
			
			return super.save(object);
		}
		else
			return null;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}



}

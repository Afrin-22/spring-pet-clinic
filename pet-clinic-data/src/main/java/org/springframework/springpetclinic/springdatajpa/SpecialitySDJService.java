package org.springframework.springpetclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.springpetclinic.model.Speciality;
import org.springframework.springpetclinic.repositories.SpecialityRepository;
import org.springframework.springpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class SpecialitySDJService implements SpecialityService {

	private final SpecialityRepository specialityRepository;
	
	public SpecialitySDJService(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<>();
		specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		return specialityRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialityRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}

	
}

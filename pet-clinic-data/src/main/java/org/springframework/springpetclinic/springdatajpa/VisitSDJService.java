package org.springframework.springpetclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.springpetclinic.model.Visit;
import org.springframework.springpetclinic.repositories.VisitRepository;
import org.springframework.springpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitSDJService implements VisitService {

	private final VisitRepository visitRepository;
	
	public VisitSDJService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}
}

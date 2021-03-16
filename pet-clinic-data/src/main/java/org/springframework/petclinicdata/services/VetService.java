package org.springframework.petclinicdata.services;

import java.util.Set;

import org.springframework.petclinicdata.model.Vet;

public interface VetService {

	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
}

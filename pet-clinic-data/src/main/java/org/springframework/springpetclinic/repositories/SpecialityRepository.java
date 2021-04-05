package org.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.springpetclinic.model.Pet;
import org.springframework.springpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long>{

}

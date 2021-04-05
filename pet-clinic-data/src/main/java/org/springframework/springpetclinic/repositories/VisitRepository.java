package org.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}

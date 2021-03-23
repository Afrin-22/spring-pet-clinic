package org.springframework.springpetclinic.services;

import org.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

}

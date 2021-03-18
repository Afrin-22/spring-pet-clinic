package org.springframework.petclinicdata.services;

import org.springframework.petclinicdata.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

}

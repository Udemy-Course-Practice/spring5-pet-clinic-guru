package com.spring5.petclinic.services;

import com.spring5.petclinic.model.Owner;
import com.spring5.petclinic.model.Person;

public interface OwnerService<O extends Person, L extends Number> extends CrudService<Owner, Long> {

    Owner findByLastname(String lastname);
}

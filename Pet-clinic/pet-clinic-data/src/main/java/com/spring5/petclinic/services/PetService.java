package com.spring5.petclinic.services;

import com.spring5.petclinic.model.BaseEntity;
import com.spring5.petclinic.model.Pet;

public interface PetService<P extends BaseEntity, L extends Number> extends CrudService<Pet, Long> {

}

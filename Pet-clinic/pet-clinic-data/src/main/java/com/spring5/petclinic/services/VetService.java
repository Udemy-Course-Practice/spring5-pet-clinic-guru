package com.spring5.petclinic.services;

import com.spring5.petclinic.model.Person;
import com.spring5.petclinic.model.Vet;

public interface VetService<V extends Person, L extends Number> extends CrudService<Vet, Long>{

}

package com.spring5.petclinic.services;

import com.spring5.petclinic.model.Owner;
import com.spring5.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}

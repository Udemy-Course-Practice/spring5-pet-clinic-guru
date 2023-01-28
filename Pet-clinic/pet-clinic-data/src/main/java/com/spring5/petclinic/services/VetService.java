package com.spring5.petclinic.services;

import com.spring5.petclinic.model.Owner;
import com.spring5.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}

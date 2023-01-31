package com.spring5.petclinic.services.springdatajpa;

import com.spring5.petclinic.model.Pet;
import com.spring5.petclinic.repositories.PetRepository;
import com.spring5.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring_data_jpa")
public class PetSDJpaService implements PetService {
    private final PetRepository petRepository;

    public PetSDJpaService( PetRepository  petRepository) {
        this. petRepository =  petRepository;
    }

    @Override
    public Pet save(Pet object) {
        return  petRepository.save(object);
    }

    @Override
    public  Pet findById(Long aLong) {
        return  petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set< Pet> findALl() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach( pets::add);
        return pets;
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }

    @Override
    public void delete( Pet object) {
        petRepository.delete(object);
    }
}

package com.spring5.petclinic.services.springdatajpa;

import com.spring5.petclinic.model.PetType;
import com.spring5.petclinic.repositories.PetTypeRepository;
import com.spring5.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring_data_jpa")
public class PetTypeSDJpaService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository  petTypeRepository) {
        this. petTypeRepository =  petTypeRepository;
    }

    @Override
    public PetType save(PetType object) {
        return  petTypeRepository.save(object);
    }

    @Override
    public  PetType findById(Long aLong) {
        return  petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<PetType> findALl() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach( petTypes::add);
        return petTypes;
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }

    @Override
    public void delete( PetType object) {
        petTypeRepository.delete(object);
    }
}

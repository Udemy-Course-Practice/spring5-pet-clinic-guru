package com.spring5.petclinic.services.springdatajpa;

import com.spring5.petclinic.model.Vet;
import com.spring5.petclinic.repositories.VetRepository;
import com.spring5.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("spring_data_jpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public Vet findById(Long aLong) {
        Optional<Vet> vet = vetRepository.findById(aLong);
        if (vet.isPresent()) {
            return vet.get();
        }
        return null;
    }

    @Override
    public Set<Vet> findALl() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }
}

package com.spring5.petclinic.services.map;

import com.spring5.petclinic.model.Owner;
import com.spring5.petclinic.services.OwnerService;
import com.spring5.petclinic.services.PetService;
import com.spring5.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petMapService;
    private final PetTypeService petTypeMapService;

    public OwnerMapService(PetMapService petMapService, PetTypeMapService petTypeMapService) {
        this.petMapService = petMapService;
        this.petTypeMapService = petTypeMapService;
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if(object.getPets().size() != 0){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeMapService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type not exits");
                    }

                    if(pet.getId() == null){
                        petMapService.save(pet);
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Set<Owner> findALl() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastname(String lastname) {
        return null;
    }
}

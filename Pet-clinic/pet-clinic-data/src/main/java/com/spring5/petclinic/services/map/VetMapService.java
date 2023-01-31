package com.spring5.petclinic.services.map;

import com.spring5.petclinic.model.Vet;
import com.spring5.petclinic.services.SpecialityService;
import com.spring5.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        if (object != null) {
            if (object.getSpecialities().size() > 0) {
                object.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        specialityService.save(speciality);
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Set<Vet> findALl() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}

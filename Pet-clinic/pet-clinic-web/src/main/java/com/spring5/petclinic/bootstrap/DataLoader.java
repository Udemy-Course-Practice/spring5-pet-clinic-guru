package com.spring5.petclinic.bootstrap;

import com.spring5.petclinic.model.*;
import com.spring5.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;

    private PetTypeService petTypeService;

    private PetService petService;

    private SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        Integer petTypeSize = petTypeService.findALl().size();

        if (petTypeSize == null || petTypeSize == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType petTypeDog = new PetType();
        petTypeDog.setName("This type pet is Dog");
        PetType typeDogSaved = petTypeService.save(petTypeDog);

        PetType petTypeCat = new PetType();
        petTypeCat.setName("This type pet is Cat");

        Owner owner1 = new Owner();
        owner1.setFirstName("Vinh ");
        owner1.setLastName("NT");
        owner1.setAddress("Bac Ninh");
        owner1.setCity("Bac Ninh");
        owner1.setTelephone("0971807597");

        Pet pet1 = new Pet();
        pet1.setPetType(petTypeDog);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        owner1.getPets().add(pet1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Trung ");
        owner2.setLastName("NQ");
        owner2.setAddress("Phu tho");
        owner2.setCity("Phu Tho");
        owner2.setTelephone("0971807596");

        Pet pet2 = new Pet();
        pet2.setPetType(petTypeCat);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(pet2);

        ownerService.save(owner1);
        ownerService.save(owner2);

        Speciality speciality1 = new Speciality();
        speciality1.setDescription("This is description Speciality of vet1");

        Vet vet1 = new Vet();
        vet1.setFirstName("Khanh ");
        vet1.setLastName("VD");
        vet1.getSpecialities().add(speciality1);
        vetService.save(vet1);

        Speciality speciality2 = new Speciality();
        speciality2.setDescription("This is description Speciality of vet2");
        Speciality specialitySaved = specialityService.save(speciality2);

        Vet vet2 = new Vet();
        vet2.setFirstName("Toan ");
        vet2.setLastName("NC");
        vet2.getSpecialities().add(specialitySaved);

        vetService.save(vet2);
    }
}

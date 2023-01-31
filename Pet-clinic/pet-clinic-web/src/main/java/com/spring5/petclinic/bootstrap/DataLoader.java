package com.spring5.petclinic.bootstrap;

import com.spring5.petclinic.model.Owner;
import com.spring5.petclinic.model.Pet;
import com.spring5.petclinic.model.PetType;
import com.spring5.petclinic.model.Vet;
import com.spring5.petclinic.services.OwnerService;
import com.spring5.petclinic.services.PetService;
import com.spring5.petclinic.services.PetTypeService;
import com.spring5.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;

    private PetTypeService petTypeService;

    private PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

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

        Vet vet1 = new Vet();
        vet1.setFirstName("Khanh ");
        vet1.setLastName("VD");

        Vet vet2 = new Vet();
        vet2.setFirstName("Toan ");
        vet2.setLastName("NC");

        vetService.save(vet1);
        vetService.save(vet2);

    }
}

package com.spring5.petclinic.bootstrap;

import com.spring5.petclinic.model.Owner;
import com.spring5.petclinic.model.Vet;
import com.spring5.petclinic.services.OwnerService;
import com.spring5.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }
    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Vinh ");
        owner1.setLastName("NT");

        Owner owner2 = new Owner();
        owner2.setFirstName("Trung ");
        owner2.setLastName("NQ");

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

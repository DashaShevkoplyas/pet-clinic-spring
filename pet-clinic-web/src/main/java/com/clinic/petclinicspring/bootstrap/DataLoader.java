package com.clinic.petclinicspring.bootstrap;

import com.clinic.petclinicspring.models.Owner;
import com.clinic.petclinicspring.models.Vet;
import com.clinic.petclinicspring.services.OwnerService;
import com.clinic.petclinicspring.services.VetService;
import com.clinic.petclinicspring.services.map.OwnerServiceMap;
import com.clinic.petclinicspring.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }
    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Viona");
        owner1.setLastname("Ridler");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Riddly");
        owner2.setLastname("Hoksmit");
        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Oliver");
        vet1.setLastname("Tree");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Daniel");
        vet2.setLastname("Kit");
        vetService.save(vet2);

        System.out.println("Loaded vets");
    }
}

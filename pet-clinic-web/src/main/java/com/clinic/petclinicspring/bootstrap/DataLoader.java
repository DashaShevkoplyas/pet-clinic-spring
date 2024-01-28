package com.clinic.petclinicspring.bootstrap;

import com.clinic.petclinicspring.models.Owner;
import com.clinic.petclinicspring.models.PetType;
import com.clinic.petclinicspring.models.Vet;
import com.clinic.petclinicspring.services.OwnerService;
import com.clinic.petclinicspring.services.PetTypeService;
import com.clinic.petclinicspring.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        var savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        var savedCatType = petTypeService.save(cat);

        PetType hamster = new PetType();
        hamster.setName("Hamster");
        var savedHamsterType = petTypeService.save(hamster);

        Owner owner1 = new Owner();
        owner1.setFirstName("Viona");
        owner1.setLastName("Ridler");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Riddly");
        owner2.setLastName("Hoksmit");
        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Oliver");
        vet1.setLastName("Tree");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Daniel");
        vet2.setLastName("Kit");
        vetService.save(vet2);

        System.out.println("Loaded vets");
    }
}

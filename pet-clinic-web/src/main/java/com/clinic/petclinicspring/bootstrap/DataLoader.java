package com.clinic.petclinicspring.bootstrap;

import com.clinic.petclinicspring.models.Owner;
import com.clinic.petclinicspring.models.PetType;
import com.clinic.petclinicspring.models.Vet;
import com.clinic.petclinicspring.models.Pet;
import com.clinic.petclinicspring.models.ContactInfo;
import com.clinic.petclinicspring.services.OwnerService;
import com.clinic.petclinicspring.services.PetTypeService;
import com.clinic.petclinicspring.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

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

        ContactInfo owner1Contact = new ContactInfo();
        owner1Contact.setAddress("123 Street");
        owner1Contact.setCity("California");
        owner1Contact.setPhone("1234456");
        owner1.setContactInfo(owner1Contact);

        Pet vionaPet1 = new Pet();
        vionaPet1.setName("Ricci");
        vionaPet1.setPetType(savedDogType);
        vionaPet1.setOwner(owner1);
        vionaPet1.setBirthDate(LocalDate.now());

        Pet vionaPet2 = new Pet();
        vionaPet2.setName("Colin");
        vionaPet2.setPetType(savedHamsterType);
        vionaPet2.setOwner(owner1);
        vionaPet2.setBirthDate(LocalDate.now());
        owner1.setPets(Set.of(vionaPet1, vionaPet2));

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Riddly");
        owner2.setLastName("Hoksmit");

        ContactInfo owner2Contact = new ContactInfo();
        owner2Contact.setAddress("567 Street");
        owner2Contact.setCity("Tampa");
        owner2Contact.setPhone("34567");
        owner2.setContactInfo(owner2Contact);

        Pet riddlyPet1 = new Pet();
        riddlyPet1.setName("Luck");
        riddlyPet1.setPetType(savedCatType);
        riddlyPet1.setOwner(owner2);
        riddlyPet1.setBirthDate(LocalDate.now());
        owner2.setPets(Set.of(riddlyPet1));

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

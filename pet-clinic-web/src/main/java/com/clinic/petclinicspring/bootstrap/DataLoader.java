package com.clinic.petclinicspring.bootstrap;

import com.clinic.petclinicspring.models.ContactInfo;
import com.clinic.petclinicspring.models.Owner;
import com.clinic.petclinicspring.models.Pet;
import com.clinic.petclinicspring.models.PetType;
import com.clinic.petclinicspring.models.Speciality;
import com.clinic.petclinicspring.models.Vet;
import com.clinic.petclinicspring.models.Visit;
import com.clinic.petclinicspring.services.ContactInfoService;
import com.clinic.petclinicspring.services.OwnerService;
import com.clinic.petclinicspring.services.PetTypeService;
import com.clinic.petclinicspring.services.SpecialityService;
import com.clinic.petclinicspring.services.VetService;
import com.clinic.petclinicspring.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    private final ContactInfoService contactInfoService;

    public DataLoader(
            OwnerService ownerService,
            VetService vetService,
            PetTypeService petTypeService,
            SpecialityService specialityService,
            VisitService visitService,
            ContactInfoService contactInfoService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.contactInfoService = contactInfoService;
    }

    @Override
    public void run(String... args) throws Exception {
        var petTypes = petTypeService.findAll();
        if (petTypes.isEmpty()) {
            loadData();
        }
    }

    private void loadData() {
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
        contactInfoService.save(owner1Contact);

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

        Visit visit1 = new Visit();
        visit1.setPet(vionaPet1);
        visit1.setDescription("dog visit");
        visit1.setDate(LocalDate.now());

        visitService.save(visit1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Riddly");
        owner2.setLastName("Hoksmit");

        ContactInfo owner2Contact = new ContactInfo();
        owner2Contact.setAddress("567 Street");
        owner2Contact.setCity("Tampa");
        owner2Contact.setPhone("34567");
        contactInfoService.save(owner2Contact);

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

        Speciality speciality1 = new Speciality();
        speciality1.setDescription("Radiology");
        var savedSpeciality = specialityService.save(speciality1);
        vet1.setSpecialities(Set.of(savedSpeciality));
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Daniel");
        vet2.setLastName("Kit");

        Speciality speciality2 = new Speciality();
        speciality1.setDescription("Surgery");
        var savedSpeciality2 = specialityService.save(speciality2);

        Speciality speciality3 = new Speciality();
        speciality1.setDescription("Dentistry");
        var savedSpeciality3 = specialityService.save(speciality3);
        vet2.setSpecialities(Set.of(savedSpeciality2, savedSpeciality3));
        vetService.save(vet2);

        System.out.println("Loaded vets");
    }
}

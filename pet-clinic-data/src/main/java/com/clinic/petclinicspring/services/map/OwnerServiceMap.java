package com.clinic.petclinicspring.services.map;

import com.clinic.petclinicspring.models.Owner;
import com.clinic.petclinicspring.models.Pet;
import com.clinic.petclinicspring.services.OwnerService;
import com.clinic.petclinicspring.services.PetService;
import com.clinic.petclinicspring.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner == null) {
            throw new OwnerServiceException("Owner can not be null");
        }

        if (owner.getPets() == null) {
            owner.setPets(new HashSet<>());
        }

        owner.getPets().forEach(this::savePet);
        return super.save(owner);
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    private void savePet(Pet pet) {
        if (pet.getPetType() == null) {
            throw new OwnerServiceException("Pet Type is required");
        }
        if (pet.getPetType().getId() == null) {
            var savedPetType = petTypeService.save(pet.getPetType());
            pet.setPetType(savedPetType);
        }

        if (pet.getId() == null) {
            var savedPet = petService.save(pet);
            pet.setId(savedPet.getId());
        }
    }
}

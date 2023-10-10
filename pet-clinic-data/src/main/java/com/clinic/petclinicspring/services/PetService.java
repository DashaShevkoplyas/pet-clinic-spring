package com.clinic.petclinicspring.services;

import com.clinic.petclinicspring.models.Pet;

import java.util.Optional;
import java.util.Set;

public interface PetService {
    Optional<Pet> findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

    void delete();
}

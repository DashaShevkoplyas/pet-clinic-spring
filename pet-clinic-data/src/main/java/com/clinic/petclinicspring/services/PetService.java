package com.clinic.petclinicspring.services;

import com.clinic.petclinicspring.models.Pet;

import java.util.Optional;
import java.util.Set;

/**
 * Represents pet service with basic CRUD operations.
 */
public interface PetService {
    /**
     * Get particular pet by id.
     * @param id
     * @return optional of {@link Pet}
     */
    Optional<Pet> findById(Long id);

    /**
     * Save / update pet.
     * @param pet
     * @return saved entity {@link Pet}
     */
    Pet save(Pet pet);

    /**
     * Get all pets.
     * @return set of {@link Pet}
     */
    Set<Pet> findAll();

    /**
     * Delete pet by id.
     * @param id
     */
    void delete(Long id);
}

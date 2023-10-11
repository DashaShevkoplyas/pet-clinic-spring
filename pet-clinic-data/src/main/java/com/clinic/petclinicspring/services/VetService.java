package com.clinic.petclinicspring.services;

import com.clinic.petclinicspring.models.Vet;

import java.util.Optional;
import java.util.Set;

/**
 * Represents vet service with basic CRUD operations.
 */
public interface VetService {
    /**
     * Get particular vet by id.
     * @param id
     * @return optional of {@link Vet}
     */
    Optional<Vet> findById(Long id);

    /**
     * Save / update vet.
     * @param vet
     * @return saved entity {@link Vet}
     */
    Vet save(Vet vet);

    /**
     * Get all vets.
     * @return set of {@link Vet}
     */
    Set<Vet> findAll();

    /**
     * Delete vet by id.
     * @param id
     */
    void delete(Long id);
}

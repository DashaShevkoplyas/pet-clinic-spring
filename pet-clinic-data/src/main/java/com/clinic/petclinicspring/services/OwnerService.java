package com.clinic.petclinicspring.services;

import com.clinic.petclinicspring.models.Owner;

import java.util.Optional;
import java.util.Set;

/**
 * Represents owner service with basic CRUD operations.
 */
public interface OwnerService {
    /**
     * Get particular owner by last name.
     * @param lastName
     * @return entity {@link Owner}
     */
    Owner findByLastName(String lastName);

    /**
     * Get particular owner by id.
     * @param id
     * @return optional of {@link Owner}
     */
    Optional<Owner> findById(Long id);

    /**
     * Save / update owner.
     * @param owner
     * @return saved entity {@link Owner}
     */
    Owner save(Owner owner);

    /**
     * Get all owners.
     * @return set of {@link Owner}
     */
    Set<Owner> findAll();

    /**
     * Delete pet by id.
     * @param id
     */
    void delete(Long id);
}

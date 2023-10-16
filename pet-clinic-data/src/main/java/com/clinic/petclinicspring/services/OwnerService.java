package com.clinic.petclinicspring.services;

import com.clinic.petclinicspring.models.Owner;

/**
 * Represents owner service with basic CRUD operations.
 */
public interface OwnerService extends CrudService<Owner, Long> {
    /**
     * Get particular owner by last name.
     * @param lastName
     * @return entity {@link Owner}
     */
    Owner findByLastName(String lastName);
}

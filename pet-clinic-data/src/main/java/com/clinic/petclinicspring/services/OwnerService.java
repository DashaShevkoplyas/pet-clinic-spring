package com.clinic.petclinicspring.services;

import com.clinic.petclinicspring.models.Owner;

import java.util.Optional;
import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);

    Optional<Owner> findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

    void delete();
}

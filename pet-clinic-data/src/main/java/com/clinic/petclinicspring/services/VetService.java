package com.clinic.petclinicspring.services;

import com.clinic.petclinicspring.models.Vet;

import java.util.Optional;
import java.util.Set;

public interface VetService {
    Optional<Vet> findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

    void delete();
}

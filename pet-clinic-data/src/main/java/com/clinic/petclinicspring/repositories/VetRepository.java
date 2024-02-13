package com.clinic.petclinicspring.repositories;

import com.clinic.petclinicspring.models.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}

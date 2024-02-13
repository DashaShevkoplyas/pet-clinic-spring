package com.clinic.petclinicspring.repositories;

import com.clinic.petclinicspring.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

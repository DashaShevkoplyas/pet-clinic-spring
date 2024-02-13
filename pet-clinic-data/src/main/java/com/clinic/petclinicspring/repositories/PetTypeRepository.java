package com.clinic.petclinicspring.repositories;

import com.clinic.petclinicspring.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

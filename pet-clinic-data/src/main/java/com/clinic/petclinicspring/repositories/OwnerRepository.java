package com.clinic.petclinicspring.repositories;

import com.clinic.petclinicspring.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

package com.clinic.petclinicspring.repositories;

import com.clinic.petclinicspring.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}

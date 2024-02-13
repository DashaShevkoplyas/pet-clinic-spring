package com.clinic.petclinicspring.repositories;

import com.clinic.petclinicspring.models.ContactInfo;
import org.springframework.data.repository.CrudRepository;

public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long> {
}

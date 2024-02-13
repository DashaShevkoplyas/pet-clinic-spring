package com.clinic.petclinicspring.services.springdatajpa;

import com.clinic.petclinicspring.models.ContactInfo;
import com.clinic.petclinicspring.repositories.ContactInfoRepository;
import com.clinic.petclinicspring.services.ContactInfoService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Alternative implementation of the contact info service,
 * opposite of map implementation {@link com.clinic.petclinicspring.services.map.ContactInfoMapService} using JPA.
 */
@Service
@Profile("springdatajpa")
public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoRepository contactInfoRepository;

    public ContactInfoServiceImpl(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    @Override
    public Set<ContactInfo> findAll() {
        Set<ContactInfo> contactInfos = new HashSet<>();
        contactInfoRepository.findAll().forEach(contactInfos::add);
        return contactInfos;
    }

    @Override
    public Optional<ContactInfo> findById(Long id) {
        return contactInfoRepository.findById(id);
    }

    @Override
    public ContactInfo save(ContactInfo contactInfo) {
        return contactInfoRepository.save(contactInfo);
    }

    @Override
    public void deleteById(Long id) {
        contactInfoRepository.deleteById(id);
    }

    @Override
    public void delete(ContactInfo contactInfo) {
        contactInfoRepository.delete(contactInfo);
    }
}

package com.clinic.petclinicspring.services.springdatajpa;

import com.clinic.petclinicspring.models.Speciality;
import com.clinic.petclinicspring.repositories.SpecialityRepository;
import com.clinic.petclinicspring.services.SpecialityService;
import com.clinic.petclinicspring.services.map.SpecialityMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Alternative implementation of the speciality service,
 * opposite of map implementation {@link SpecialityMapService} using JPA.
 */
@Service
@Profile("springdatajpa")
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Optional<Speciality> findById(Long id) {
        return specialityRepository.findById(id);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }
}

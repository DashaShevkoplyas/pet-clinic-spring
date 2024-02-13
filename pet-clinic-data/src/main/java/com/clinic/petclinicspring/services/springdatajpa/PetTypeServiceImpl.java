package com.clinic.petclinicspring.services.springdatajpa;

import com.clinic.petclinicspring.models.PetType;
import com.clinic.petclinicspring.repositories.PetTypeRepository;
import com.clinic.petclinicspring.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Alternative implementation of the pet type service,
 * opposite of map implementation {@link com.clinic.petclinicspring.services.map.PetTypeServiceMap}.
 */
@Service
@Profile("springdatajpa")
public class PetTypeServiceImpl implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public Optional<PetType> findById(Long id) {
        return petTypeRepository.findById(id);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }
}

package com.clinic.petclinicspring.services.springdatajpa;

import com.clinic.petclinicspring.models.Vet;
import com.clinic.petclinicspring.repositories.VetRepository;
import com.clinic.petclinicspring.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Alternative implementation of the vet service,
 * opposite of map implementation {@link com.clinic.petclinicspring.services.map.VetServiceMap} using JPA.
 */
@Service
@Profile("springdatajpa")
public class VetServiceImpl implements VetService {
    private final VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Optional<Vet> findById(Long id) {
        return vetRepository.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }
}

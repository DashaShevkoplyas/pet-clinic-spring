package com.clinic.petclinicspring.services.springdatajpa;

import com.clinic.petclinicspring.models.Visit;
import com.clinic.petclinicspring.repositories.VisitRepository;
import com.clinic.petclinicspring.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Alternative implementation of the visit service,
 * opposite of map implementation {@link com.clinic.petclinicspring.services.map.VisitMapService} using JPA.
 */
@Service
@Profile("springdatajpa")
public class VisitServiceImpl implements VisitService {
    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Optional<Visit> findById(Long id) {
        return visitRepository.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);

    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }
}

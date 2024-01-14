package com.clinic.petclinicspring.services.map;

import com.clinic.petclinicspring.models.Vet;
import com.clinic.petclinicspring.services.VetService;

import java.util.Optional;
import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Optional<Vet> findById(Long id) {
        return super.findById(id);
    }
}

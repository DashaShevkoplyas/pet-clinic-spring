package com.clinic.petclinicspring.services.map;

import com.clinic.petclinicspring.models.Owner;
import com.clinic.petclinicspring.services.CrudService;

import java.util.Optional;
import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return super.findById(id);
    }
}

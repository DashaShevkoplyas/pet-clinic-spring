package com.clinic.petclinicspring.services.map;

import com.clinic.petclinicspring.models.Pet;
import com.clinic.petclinicspring.services.CrudService;

import java.util.Optional;
import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Pet save(Pet entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Optional<Pet> findById(Long id) {
        return super.findById(id);
    }
}

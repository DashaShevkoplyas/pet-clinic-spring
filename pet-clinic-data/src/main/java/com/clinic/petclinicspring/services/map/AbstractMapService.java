package com.clinic.petclinicspring.services.map;

import com.clinic.petclinicspring.models.BaseEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Optional;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Base map service.
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    Optional<T> findById(ID id) {
        return Optional.ofNullable(map.get(id));
    }

    T save(T entity) {
        if (entity == null) {
            throw new RuntimeException("Entity can not be null");
        }

        if (entity.getId() == null) {
            entity.setId(getNextId());
        }
        map.putIfAbsent(entity.getId(), entity);
        return entity;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T entity) {
        map.entrySet().removeIf(e -> e.getValue().equals(entity));
    }

    private Long getNextId() {
        try {
            return Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException ex) {
            return 1L;
        }
    }
}

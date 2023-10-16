package com.clinic.petclinicspring.services.map;

import java.util.*;

/**
 * Base map service.
 */
public abstract class AbstractMapService<T, ID> {
    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    Optional<T> findById(ID id) {
        return Optional.ofNullable(map.get(id));
    }

    T save(ID id, T entity) {
        map.putIfAbsent(id, entity);
        return entity;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T entity) {
        map.entrySet().removeIf(e -> e.getValue().equals(entity));
    }
}

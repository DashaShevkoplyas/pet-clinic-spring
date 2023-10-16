package com.clinic.petclinicspring.services;

import java.util.Optional;
import java.util.Set;

public interface CrudService<T, ID> {
    /**
     * Get all entities.
     * @return set of {@link T}
     */
    Set<T> findAll();

    /**
     * Get particular entity by id.
     * @param id
     * @return optional of {@link T}
     */
    Optional<T> findById(ID id);

    /**
     * Save / update entity.
     * @param entity
     * @return saved entity {@link T}
     */
    T save(T entity);

    /**
     * Delete entity by id.
     * @param id
     */
    void deleteById(ID id);

    /**
     * Delete entity.
     * @param entity
     */
    void delete(T entity);
}

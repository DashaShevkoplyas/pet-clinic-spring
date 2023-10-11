package com.clinic.petclinicspring.models;

import java.io.Serializable;

/**
 * Base entity class that contains id field needed by all models.
 */
public class BaseEntity implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

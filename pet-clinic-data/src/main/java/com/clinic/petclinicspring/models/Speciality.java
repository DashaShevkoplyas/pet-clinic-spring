package com.clinic.petclinicspring.models;

/**
 * Vet speciality entity class.
 */
public class Speciality extends BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

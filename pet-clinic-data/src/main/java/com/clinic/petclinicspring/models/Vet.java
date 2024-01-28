package com.clinic.petclinicspring.models;

import java.util.Set;

/**
 * Represents vet doctor.
 */
public class Vet extends Person {
    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}

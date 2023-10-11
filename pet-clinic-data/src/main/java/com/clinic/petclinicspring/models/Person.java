package com.clinic.petclinicspring.models;

/**
 * Base class with fields common to all human-being entities.
 */
public class Person extends BaseEntity {
    private String firstName;
    private String lastname;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

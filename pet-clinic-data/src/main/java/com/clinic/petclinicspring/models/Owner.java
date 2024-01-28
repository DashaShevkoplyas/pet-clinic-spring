package com.clinic.petclinicspring.models;

import java.util.Set;

/**
 * Represents owner of the pet/s.
 */
public class Owner extends Person {
    private ContactInfo contactInfo;
    private Set<Pet> pets;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}

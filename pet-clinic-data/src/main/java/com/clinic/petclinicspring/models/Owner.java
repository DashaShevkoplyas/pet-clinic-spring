package com.clinic.petclinicspring.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * Represents owner of the pet/s.
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {
    @Builder
    public Owner(Long id, String firstName, String lastName, ContactInfo contactInfo, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.contactInfo = contactInfo;
        this.pets = pets;
    }

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private ContactInfo contactInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets;
}

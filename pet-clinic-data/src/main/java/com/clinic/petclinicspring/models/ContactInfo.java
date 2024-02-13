package com.clinic.petclinicspring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Basic contact information.
 */
@Entity
@Table(name = "contacts")
public class ContactInfo extends BaseEntity {
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "phone")
    private String phone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

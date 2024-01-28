package com.clinic.petclinicspring.services.map;

/**
 * Vet service exception class.
 */
public class VetServiceException extends RuntimeException {
    VetServiceException(String message) {
        super(message);
    }
}

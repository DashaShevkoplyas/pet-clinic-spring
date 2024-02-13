package com.clinic.petclinicspring.services.exceptions;

/**
 * Vet service exception class.
 */
public class VetServiceException extends RuntimeException {
    public VetServiceException(String message) {
        super(message);
    }
}

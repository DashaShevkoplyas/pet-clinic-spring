package com.clinic.petclinicspring.services.exceptions;

/**
 * Owner service exception class.
 */
public class OwnerServiceException extends RuntimeException {
    public OwnerServiceException(String message) {
        super(message);
    }
}

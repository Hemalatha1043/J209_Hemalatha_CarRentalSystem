/**
 * The com.carrentalsystem.exception package contains custom exception classes used
 * in the car rental system.
 */
package com.carrentalsystem.exception;

/**
 * The CustomerNotFoundException class represents an exception thrown when a requested
 * customer is not found in the system.
 */
public class CustomerNotFoundException extends Exception {

    /**
     * Constructs a new CustomerNotFoundException with the specified detail message.
     * 
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public CustomerNotFoundException(String message) {
        super(message);
    }
}

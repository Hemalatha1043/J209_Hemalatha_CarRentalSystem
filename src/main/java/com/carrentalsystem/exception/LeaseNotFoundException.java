/**
 * The com.carrentalsystem.exception package contains custom exception classes used
 * in the car rental system.
 */
package com.carrentalsystem.exception;

/**
 * The LeaseNotFoundException class represents an exception thrown when a
 * requested lease is not found in the system.
 */
public class LeaseNotFoundException extends Exception {

	/**
	 * Constructs a new LeaseNotFoundException with the specified detail message.
	 * 
	 * @param message the detail message (which is saved for later retrieval by the
	 *                getMessage() method)
	 */
	public LeaseNotFoundException(String message) {
		super(message);
	}
}

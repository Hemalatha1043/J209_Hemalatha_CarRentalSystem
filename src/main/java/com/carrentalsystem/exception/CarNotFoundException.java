/**
 * The com.carrentalsystem.exception package contains custom exception classes used
 * in the car rental system.
 */
package com.carrentalsystem.exception;

/**
 * The CarNotFoundException class represents an exception thrown when a
 * requested car is not found in the system.
 */
public class CarNotFoundException extends Exception {

	/**
	 * Constructs a new CarNotFoundException with the specified detail message.
	 * 
	 * @param message the detail message (which is saved for later retrieval by the
	 *                getMessage() method)
	 */
	public CarNotFoundException(String message) {
		super(message);
	}
}

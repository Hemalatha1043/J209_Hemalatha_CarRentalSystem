/**
 * The com.carrentalsystem.entity package contains the Customer class.
 */
package com.carrentalsystem.entity;

/**
 * The Customer class represents a customer in a car rental system. It
 * encapsulates information such as customer ID, first name, last name, email,
 * and phone number.
 */
public class Customer {
	private int customerID; // The unique identifier for the customer
	private String firstName; // The first name of the customer
	private String lastName; // The last name of the customer
	private String email; // The email address of the customer
	private String phoneNumber; // The phone number of the customer

	/**
	 * Constructs a new Customer object with the specified values.
	 * 
	 * @param customerID  The unique identifier for the customer
	 * @param firstName   The first name of the customer
	 * @param lastName    The last name of the customer
	 * @param email       The email address of the customer
	 * @param phoneNumber The phone number of the customer
	 */
	public Customer(int customerID, String firstName, String lastName, String email, String phoneNumber) {
		// Initialize the attributes with the provided values
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Retrieves the customer ID.
	 * 
	 * @return The customer ID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * Sets the customer ID.
	 * 
	 * @param customerID The customer ID to set
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * Retrieves the first name of the customer.
	 * 
	 * @return The first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the customer.
	 * 
	 * @param firstName The first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieves the last name of the customer.
	 * 
	 * @return The last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the customer.
	 * 
	 * @param lastName The last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retrieves the email address of the customer.
	 * 
	 * @return The email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the customer.
	 * 
	 * @param email The email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieves the phone number of the customer.
	 * 
	 * @return The phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number of the customer.
	 * 
	 * @param phoneNumber The phone number to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Returns the string representation of the Customer object.
	 * 
	 * @return The string representation of the Customer object
	 */
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + "]";
	}
}

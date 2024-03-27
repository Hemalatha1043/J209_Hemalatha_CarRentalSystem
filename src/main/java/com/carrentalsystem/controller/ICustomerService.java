package com.carrentalsystem.controller;

import com.carrentalsystem.exception.CustomerNotFoundException;

/**
 * The ICustomerService interface defines the contract for customer-related operations in the Car Rental System.
 */
public interface ICustomerService {

    /**
     * Adds a new customer to the system.
     *
     * @param firstName    The first name of the customer.
     * @param lastName     The last name of the customer.
     * @param email        The email address of the customer.
     * @param phoneNumber  The phone number of the customer.
     */
    void addCustomer(String firstName, String lastName, String email, String phoneNumber);

    /**
     * Lists all the customers in the system.
     */
    void listCustomers();

    /**
     * Updates the details of an existing customer.
     *
     * @param customerID   The ID of the customer to update.
     * @param firstName    The updated first name of the customer.
     * @param lastName     The updated last name of the customer.
     * @param email        The updated email address of the customer.
     * @param phoneNumber  The updated phone number of the customer.
     * @throws CustomerNotFoundException if the customer is not found.
     */
    void updateCustomer(int customerID, String firstName, String lastName, String email, String phoneNumber) throws CustomerNotFoundException;

}

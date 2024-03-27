package com.carrentalsystem.controller;

import com.carrentalsystem.entity.Customer;
import com.carrentalsystem.exception.CustomerNotFoundException;
import com.carrentalsystem.dao.ICarLeaseRepositoryImpl;
import java.sql.SQLException;
import java.util.List;

/**
 * The CustomerService class provides methods to interact with the customer
 * repository and perform operations related to customers in the car rental
 * system.
 */
public class CustomerService implements ICustomerService {
	private ICarLeaseRepositoryImpl customerDAO;

	/**
	 * Constructs a new CustomerService object with the default customer repository
	 * implementation.
	 */
	public CustomerService() {
		this.customerDAO = new ICarLeaseRepositoryImpl();
	}

	/**
	 * Adds a new customer to the system.
	 *
	 * @param firstName   The first name of the customer
	 * @param lastName    The last name of the customer
	 * @param email       The email address of the customer
	 * @param phoneNumber The phone number of the customer
	 */
	@Override
	public void addCustomer(String firstName, String lastName, String email, String phoneNumber) {
		Customer customer = new Customer(0, firstName, lastName, email, phoneNumber);

		try {
			customerDAO.addCustomer(customer);
			System.out.println("Customer added successfully.");
		} catch (SQLException e) {
			System.err.println("Error adding customer: " + e.getMessage());
		}
	}

	/**
	 * Lists all customers in the system.
	 */
	@Override
	public void listCustomers() {
		try {
			List<Customer> customers = customerDAO.listCustomers();

			System.out.println("Customers:");
			for (Customer customer : customers) {
				System.out.println(customer.toString());
			}
		} catch (SQLException e) {
			System.err.println("Error listing customers: " + e.getMessage());
		}
	}

	/**
	 * Updates customer information in the system.
	 *
	 * @param customerID  The ID of the customer to be updated
	 * @param firstName   The updated first name of the customer
	 * @param lastName    The updated last name of the customer
	 * @param email       The updated email address of the customer
	 * @param phoneNumber The updated phone number of the customer
	 * @throws CustomerNotFoundException if the customer with the specified ID is
	 *                                   not found
	 */
	@Override
	public void updateCustomer(int customerID, String firstName, String lastName, String email, String phoneNumber)
			throws CustomerNotFoundException {
		Customer customer = new Customer(customerID, firstName, lastName, email, phoneNumber);

		try {
			customerDAO.updateCustomer(customer);
			System.out.println("Customer information updated successfully.");
		} catch (SQLException e) {
			System.err.println("Error updating customer information: " + e.getMessage());
		}
	}

}

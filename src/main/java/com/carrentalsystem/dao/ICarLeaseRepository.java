package com.carrentalsystem.dao;

import com.carrentalsystem.entity.Vehicle;
import com.carrentalsystem.entity.Customer;
import com.carrentalsystem.entity.Lease;
import com.carrentalsystem.entity.Payment;
import com.carrentalsystem.exception.CarNotFoundException;
import com.carrentalsystem.exception.CustomerNotFoundException;
import com.carrentalsystem.exception.LeaseNotFoundException;

import java.sql.SQLException;
import java.util.List;

/**
 * The ICarLeaseRepository interface defines methods for interacting with the
 * car rental system's data repository.
 */
public interface ICarLeaseRepository {
	// Car Management

	/**
	 * Adds a new car to the repository.
	 *
	 * @param car The car to add
	 * @throws SQLException if a database access error occurs
	 */
	void addCar(Vehicle car) throws SQLException;

	/**
	 * Removes a car from the repository.
	 *
	 * @param carID The ID of the car to remove
	 * @throws CarNotFoundException if the specified car is not found
	 * @throws SQLException         if a database access error occurs
	 */
	void removeCar(int carID) throws CarNotFoundException, SQLException;

	/**
	 * Lists all available cars in the repository.
	 *
	 * @return A list of available cars
	 * @throws SQLException if a database access error occurs
	 */
	List<Vehicle> listAvailableCars() throws SQLException;

	/**
	 * Lists all rented cars in the repository.
	 *
	 * @return A list of rented cars
	 * @throws SQLException if a database access error occurs
	 */
	List<Vehicle> listRentedCars() throws SQLException;

	/**
	 * Finds a car by its ID.
	 *
	 * @param carID The ID of the car to find
	 * @return The found car
	 * @throws CarNotFoundException if the specified car is not found
	 * @throws SQLException         if a database access error occurs
	 */
	Vehicle findCarById(int carID) throws CarNotFoundException, SQLException;

	// Customer Management

	/**
	 * Adds a new customer to the repository.
	 *
	 * @param customer The customer to add
	 * @throws SQLException if a database access error occurs
	 */
	void addCustomer(Customer customer) throws SQLException;

	/**
	 * Removes a customer from the repository.
	 *
	 * @param customerID The ID of the customer to remove
	 * @throws CustomerNotFoundException if the specified customer is not found
	 * @throws SQLException              if a database access error occurs
	 */
	void removeCustomer(int customerID) throws CustomerNotFoundException, SQLException;

	/**
	 * Lists all customers in the repository.
	 *
	 * @return A list of customers
	 * @throws SQLException if a database access error occurs
	 */
	List<Customer> listCustomers() throws SQLException;

	/**
	 * Finds a customer by their ID.
	 *
	 * @param customerID The ID of the customer to find
	 * @return The found customer
	 * @throws CustomerNotFoundException if the specified customer is not found
	 * @throws SQLException              if a database access error occurs
	 */
	Customer findCustomerById(int customerID) throws CustomerNotFoundException, SQLException;

	/**
	 * Updates customer information in the repository.
	 *
	 * @param customer The updated customer information
	 * @throws CustomerNotFoundException if the specified customer is not found
	 * @throws SQLException              if a database access error occurs
	 */
	void updateCustomer(Customer customer) throws CustomerNotFoundException, SQLException;

	// Lease Management

	/**
	 * Creates a new lease in the repository.
	 *
	 * @param lease The lease to create
	 * @throws SQLException if a database access error occurs
	 * @throws CustomerNotFoundException 
	 */
	void createLease(Lease lease) throws SQLException;

	/**
	 * Returns a leased car and completes the lease.
	 *
	 * @param leaseID The ID of the lease to return
	 * @return A list of leases containing the returned lease
	 * @throws LeaseNotFoundException if the specified lease is not found
	 * @throws SQLException           if a database access error occurs
	 */
	List<Lease> returnCar(int leaseID) throws LeaseNotFoundException, SQLException;

	/**
	 * Checks if a lease exists with the specified ID.
	 *
	 * @param leaseID The ID of the lease to check
	 * @return true if the lease exists, otherwise false
	 * @throws LeaseNotFoundException if the specified lease is not found
	 * @throws SQLException           if a database access error occurs
	 */
	boolean findLeaseById(int leaseID) throws LeaseNotFoundException, SQLException;

	/**
	 * Lists all active leases in the repository.
	 *
	 * @return A list of active leases
	 * @throws SQLException if a database access error occurs
	 */
	List<Lease> listActiveLeases() throws SQLException;

	/**
	 * Lists the lease history in the repository.
	 *
	 * @return A list of lease history
	 * @throws SQLException if a database access error occurs
	 */
	List<Lease> listLeaseHistory() throws SQLException;

	/**
	 * Calculates the cost of a lease.
	 *
	 * @param leaseID The ID of the lease
	 * @return The calculated cost of the lease
	 * @throws SQLException           if a database access error occurs
	 * @throws LeaseNotFoundException if the specified lease is not found
	 */
	double calculateLeaseCost(int leaseID) throws SQLException, LeaseNotFoundException;

	// Payment Handling

	/**
	 * Records a payment in the repository.
	 *
	 * @param paymentID   The ID of the payment
	 * @param leaseID     The ID of the associated lease
	 * @param amount      The amount of the payment
	 * @param paymentDate The date of the payment
	 * @throws SQLException if a database access error occurs
	 */
	void recordPayment(int paymentID, int leaseID, float amount, java.util.Date paymentDate) throws SQLException;

	/**
	 * Retrieves the payment history for a customer.
	 *
	 * @param customerID The ID of the customer
	 * @return A list of payments made by the customer
	 * @throws SQLException if a database access error occurs
	 */
	List<Payment> retrievePaymentHistory(int customerID) throws SQLException;

	/**
	 * Calculates the total revenue generated from payments.
	 *
	 * @return The total revenue
	 * @throws SQLException if a database access error occurs
	 */
	double calculateTotalRevenue() throws SQLException;
}

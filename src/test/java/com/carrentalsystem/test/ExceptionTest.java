package com.carrentalsystem.test;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.carrentalsystem.dao.ICarLeaseRepository;
import com.carrentalsystem.dao.ICarLeaseRepositoryImpl;
import com.carrentalsystem.exception.CarNotFoundException;
import com.carrentalsystem.exception.CustomerNotFoundException;
import com.carrentalsystem.exception.LeaseNotFoundException;

/**
 * ExceptionTest class provides test cases for handling exceptions in the Car
 * Rental System application.
 */
public class ExceptionTest {
	private ICarLeaseRepository carLeaseRepository;

	/**
	 * Sets up the test environment before each test case.
	 */
	@Before
	public void setUp() {
		System.out.println("From Setup() CarLeaseRepository");
		carLeaseRepository = new ICarLeaseRepositoryImpl();
	}

	/**
	 * Test case to verify CarNotFoundException is thrown when a car is not found.
	 *
	 * @throws SQLException         if a database access error occurs
	 * @throws CarNotFoundException if the car is not found
	 */
	@Test(expected = CarNotFoundException.class)
	public void testCarNotFound() throws SQLException, CarNotFoundException {
		carLeaseRepository.findCarById(20);
	}

	/**
	 * Test case to verify CustomerNotFoundException is thrown when a customer is
	 * not found.
	 *
	 * @throws SQLException              if a database access error occurs
	 * @throws CustomerNotFoundException if the customer is not found
	 */
	@Test(expected = CustomerNotFoundException.class)
	public void testCustomerNotFound() throws SQLException, CustomerNotFoundException {
		carLeaseRepository.findCustomerById(20);
	}

	/**
	 * Test case to verify LeaseNotFoundException is thrown when a lease is not
	 * found.
	 *
	 * @throws SQLException           if a database access error occurs
	 * @throws LeaseNotFoundException if the lease is not found
	 */
	@Test(expected = LeaseNotFoundException.class)
	public void testLeaseNotFound() throws SQLException, LeaseNotFoundException {
		carLeaseRepository.findLeaseById(20);
	}

	/**
	 * Cleans up the test environment after each test case.
	 */
	@After
	public void tearDown() {
		System.out.println("From tearDown() carLeaseRepository");
		carLeaseRepository = null;
	}

}

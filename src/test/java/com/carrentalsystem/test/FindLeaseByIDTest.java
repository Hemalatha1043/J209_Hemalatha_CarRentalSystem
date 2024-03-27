package com.carrentalsystem.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.carrentalsystem.dao.ICarLeaseRepository;
import com.carrentalsystem.dao.ICarLeaseRepositoryImpl;
import com.carrentalsystem.exception.LeaseNotFoundException;

/**
 * FindLeaseByIDTest class provides test cases for finding a lease by ID in the
 * Car Rental System application.
 */
public class FindLeaseByIDTest {

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
	 * Test case to verify that a lease is found by its ID.
	 *
	 * @throws LeaseNotFoundException if the lease is not found
	 */
	@Test
	public void testFindLeaseByID() throws LeaseNotFoundException {
		try {
			assertTrue("Lease found:", carLeaseRepository.findLeaseById(10));
		} catch (SQLException e) {
			e.printStackTrace();
			assertTrue(false);
		}
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

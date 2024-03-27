package com.carrentalsystem.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.carrentalsystem.dao.ICarLeaseRepositoryImpl;
import com.carrentalsystem.entity.Lease;

/**
 * LeaseTest class provides test cases for creating a lease in the Car Rental
 * System application.
 */
public class LeaseTest {
	private ICarLeaseRepositoryImpl carLeaseRepository;

	/**
	 * Sets up the test environment before each test case.
	 */
	@Before
	public void setUp() {
		System.out.println("From Setup() CarLeaseRepository");
		carLeaseRepository = new ICarLeaseRepositoryImpl();
	}

	/**
	 * Test case to verify the creation of a lease.
	 */
	@Test
	public void testCreateLease() {
		try {
			Lease lease = new Lease();
			lease.setLeaseID(18);
			lease.setVehicleID(6);
			lease.setCustomerID(5);
			lease.setStartDate(new java.util.Date());
			lease.setEndDate(new java.util.Date());
			lease.setType("DailyLease");
			lease.setState("active");
			boolean result = carLeaseRepository.createLeaseTest(lease);
			assertTrue(result);
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
	}
}

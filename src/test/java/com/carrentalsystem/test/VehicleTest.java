package com.carrentalsystem.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.carrentalsystem.dao.ICarLeaseRepositoryImpl;
import com.carrentalsystem.entity.Vehicle;

/**
 * VehicleTest class provides test cases for adding a new vehicle in the Car
 * Rental System application.
 */
public class VehicleTest {
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
	 * Test case to verify the addition of a new car.
	 */
	@Test
	public void testAddCar() {
		try {
			Vehicle car = new Vehicle();
			car.setVehicleID(12);
			car.setMake("Mercedes");
			car.setModel("GLA");
			car.setYear(2022);
			car.setDailyRate(55);
			car.setStatus("available");
			car.setPassengerCapacity(5);
			car.setEngineCapacity(1950);
			assertTrue("Car added successfully.", carLeaseRepository.addCarTest(car));
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

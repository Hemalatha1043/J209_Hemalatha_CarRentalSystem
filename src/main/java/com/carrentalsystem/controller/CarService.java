package com.carrentalsystem.controller;

import com.carrentalsystem.dao.ICarLeaseRepositoryImpl;
import com.carrentalsystem.entity.Vehicle;
import com.carrentalsystem.exception.CarNotFoundException;

import java.sql.SQLException;
import java.util.List;

/**
 * The CarService class provides methods to interact with the car repository and
 * perform operations related to cars in the car rental system.
 */
public class CarService implements ICarService{
	private ICarLeaseRepositoryImpl carDao;

	/**
	 * Constructs a new CarService object with the default car repository
	 * implementation.
	 */
	public CarService() {
		this.carDao = new ICarLeaseRepositoryImpl();
	}

	/**
	 * Adds a new car to the system.
	 *
	 * @param vehicleID         The ID of the vehicle
	 * @param make              The make of the vehicle
	 * @param model             The model of the vehicle
	 * @param year              The year of the vehicle
	 * @param dailyRate         The daily rental rate of the vehicle
	 * @param status            The status of the vehicle
	 * @param passengerCapacity The passenger capacity of the vehicle
	 * @param engineCapacity    The engine capacity of the vehicle
	 */
	@Override
	public void addCar(int vehicleID, String make, String model, int year, float dailyRate, String status,
			int passengerCapacity, int engineCapacity) {
		Vehicle car = new Vehicle(vehicleID, make, model, year, dailyRate, status, passengerCapacity, engineCapacity);

		try {
			carDao.addCar(car);
			System.out.println("Car added successfully.");
		} catch (SQLException e) {
			System.err.println("Error adding car: " + e.getMessage());
		}
	}
	

	/**
	 * Removes a car from the system based on the specified car ID.
	 *
	 * @param carID The ID of the car to be removed
	 */
	@Override
	public void removeCar(int carID) {
		try {
			carDao.removeCar(carID);
		} catch (CarNotFoundException | SQLException e) {
			System.err.println("Error removing car: " + e.getMessage());
		}
	}

	/**
	 * Lists all available cars in the system.
	 */
	@Override
	public void listAvailableCars() {
		try {
			List<Vehicle> availableCars = carDao.listAvailableCars();
			System.out.println("Available Cars:");
			for (Vehicle car : availableCars) {
				System.out.println(car.toString());
			}
		} catch (SQLException e) {
			System.err.println("Error listing available cars: " + e.getMessage());
		}
	}

	/**
	 * Lists all rented cars in the system.
	 */
	@Override
	public void listRentedCars() {
		try {
			List<Vehicle> rentedCars = carDao.listRentedCars();
			System.out.println("Rented Cars:");
			for (Vehicle car : rentedCars) {
				System.out.println(car.toString());
			}
		} catch (SQLException e) {
			System.err.println("Error listing rented cars: " + e.getMessage());
		}
	}

	/**
	 * Finds a car in the system based on the specified car ID.
	 *
	 * @param carID The ID of the car to be found
	 */
	@Override
	public void findCarById(int carID) {
		try {
			carDao.findCarById(carID);
		} catch (CarNotFoundException | SQLException e) {
			System.err.println("Error finding car: " + e.getMessage());
		}
	}

	
}

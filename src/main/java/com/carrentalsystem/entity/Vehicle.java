/**
 * The com.carrentalsystem.entity package contains the Vehicle class, which represents a vehicle in a car rental system.
 * It encapsulates information such as vehicle ID, make, model, year, daily rate, status, passenger capacity, and engine capacity.
 */
package com.carrentalsystem.entity;

/**
 * The Vehicle class represents a vehicle in a car rental system. It
 * encapsulates information such as vehicle ID, make, model, year, daily rate,
 * status, passenger capacity, and engine capacity.
 */
public class Vehicle {
	private int vehicleID; // The unique identifier for the vehicle
	private String make; // The make of the vehicle
	private String model; // The model of the vehicle
	private int year; // The year of the vehicle
	private float dailyRate; // The daily rental rate of the vehicle
	private String status; // The status of the vehicle (e.g., available, rented)
	private int passengerCapacity; // The passenger capacity of the vehicle
	private int engineCapacity; // The engine capacity of the vehicle

	/**
	 * Constructs a new Vehicle object with default values.
	 */
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs a new Vehicle object with the specified attributes.
	 * 
	 * @param vehicleID         The unique identifier for the vehicle.
	 * @param make              The make of the vehicle.
	 * @param model             The model of the vehicle.
	 * @param year              The year of the vehicle.
	 * @param dailyRate         The daily rental rate of the vehicle.
	 * @param status            The status of the vehicle (e.g., available, rented).
	 * @param passengerCapacity The passenger capacity of the vehicle.
	 * @param engineCapacity    The engine capacity of the vehicle.
	 */
	public Vehicle(int vehicleID, String make, String model, int year, float dailyRate, String status,
			int passengerCapacity, int engineCapacity) {
		super();
		this.vehicleID = vehicleID;
		this.make = make;
		this.model = model;
		this.year = year;
		this.dailyRate = dailyRate;
		this.status = status;
		this.passengerCapacity = passengerCapacity;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Returns the unique identifier for the vehicle.
	 * 
	 * @return The vehicle ID.
	 */
	public int getVehicleID() {
		return vehicleID;
	}

	/**
	 * Sets the unique identifier for the vehicle.
	 * 
	 * @param vehicleID The vehicle ID to set.
	 */
	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	/**
	 * Returns the make of the vehicle.
	 * 
	 * @return The make of the vehicle.
	 */
	public String getMake() {
		return make;
	}

	/**
	 * Sets the make of the vehicle.
	 * 
	 * @param make The make of the vehicle to set.
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * Returns the model of the vehicle.
	 * 
	 * @return The model of the vehicle.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model of the vehicle.
	 * 
	 * @param model The model of the vehicle to set.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Returns the year of the vehicle.
	 * 
	 * @return The year of the vehicle.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year of the vehicle.
	 * 
	 * @param year The year of the vehicle to set.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Returns the daily rental rate of the vehicle.
	 * 
	 * @return The daily rental rate of the vehicle.
	 */
	public float getDailyRate() {
		return dailyRate;
	}

	/**
	 * Sets the daily rental rate of the vehicle.
	 * 
	 * @param dailyRate The daily rental rate of the vehicle to set.
	 */
	public void setDailyRate(float dailyRate) {
		this.dailyRate = dailyRate;
	}

	/**
	 * Returns the status of the vehicle.
	 * 
	 * @return The status of the vehicle.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of the vehicle.
	 * 
	 * @param status The status of the vehicle to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Returns the passenger capacity of the vehicle.
	 * 
	 * @return The passenger capacity of the vehicle.
	 */
	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	/**
	 * Sets the passenger capacity of the vehicle.
	 * 
	 * @param passengerCapacity The passenger capacity of the vehicle to set.
	 */
	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	/**
	 * Returns the engine capacity of the vehicle.
	 * 
	 * @return The engine capacity of the vehicle.
	 */
	public int getEngineCapacity() {
		return engineCapacity;
	}

	/**
	 * Sets the engine capacity of the vehicle.
	 * 
	 * @param engineCapacity The engine capacity of the vehicle to set.
	 */
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleID=" + vehicleID + ", make=" + make + ", model=" + model + ", year=" + year
				+ ", dailyRate=" + dailyRate + ", status=" + status + ", passengerCapacity=" + passengerCapacity
				+ ", engineCapacity=" + engineCapacity + "]";
	}

	/**
	 * Returns the string representation of the Vehicle object.
	 * 
	 * @return The string representation of the Vehicle object.
	 */
	
}

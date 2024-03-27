package com.carrentalsystem.controller;

/**
 * The ICarService interface defines the contract for car-related operations in the Car Rental System.
 */
public interface ICarService {

    /**
     * Adds a new car to the system.
     *
     * @param vehicleID          The ID of the vehicle.
     * @param make               The make of the car.
     * @param model              The model of the car.
     * @param year               The year of the car.
     * @param dailyRate          The daily rental rate of the car.
     * @param status             The status of the car (e.g., available, rented).
     * @param passengerCapacity  The passenger capacity of the car.
     * @param engineCapacity     The engine capacity of the car.
     */
    void addCar(int vehicleID, String make, String model, int year, float dailyRate, String status,
                int passengerCapacity, int engineCapacity);

    /**
     * Removes a car from the system.
     *
     * @param carID  The ID of the car to be removed.
     */
    void removeCar(int carID);

    /**
     * Lists all available cars in the system.
     */
    void listAvailableCars();

    /**
     * Lists all rented cars in the system.
     */
    void listRentedCars();

    /**
     * Finds a car by its ID.
     *
     * @param carID  The ID of the car to find.
     */
    void findCarById(int carID);

}

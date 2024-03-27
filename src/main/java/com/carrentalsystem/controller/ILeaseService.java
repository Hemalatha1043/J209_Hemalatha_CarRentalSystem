package com.carrentalsystem.controller;

import java.util.Date;
import java.util.List;

import com.carrentalsystem.entity.Lease;
import com.carrentalsystem.exception.LeaseNotFoundException;

/**
 * The ILeaseService interface defines the contract for lease-related operations in the Car Rental System.
 */
public interface ILeaseService {

    /**
     * Creates a new lease.
     *
     * @param leaseID     The ID of the lease.
     * @param vehicleID   The ID of the vehicle being leased.
     * @param customerID  The ID of the customer leasing the vehicle.
     * @param startDate   The start date of the lease.
     * @param endDate     The end date of the lease.
     * @param type        The type of lease (e.g., "DailyLease", "MonthlyLease").
     * @param state       The state of the lease (e.g., "active", "terminated").
     */
    void createLease(int leaseID, int vehicleID, int customerID, Date startDate, Date endDate, String type,
                     String state);

    /**
     * Returns a leased car, ending the lease.
     *
     * @param leaseID The ID of the lease to return the car for.
     * @return A list of leases with the returned car.
     * @throws LeaseNotFoundException if the lease is not found.
     */
    List<Lease> returnCar(int leaseID) throws LeaseNotFoundException;

    /**
     * Retrieves a list of active leases.
     *
     * @return A list of active leases.
     */
    List<Lease> listActiveLeases();

    /**
     * Retrieves a list of lease history.
     *
     * @return A list of lease history.
     */
    List<Lease> listLeaseHistory();

    /**
     * Calculates the cost of a lease.
     *
     * @param leaseID The ID of the lease.
     * @return The cost of the lease.
     */
    double calculateLeaseCost(int leaseID);

}

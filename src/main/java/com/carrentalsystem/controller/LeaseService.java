package com.carrentalsystem.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.carrentalsystem.dao.ICarLeaseRepositoryImpl;
import com.carrentalsystem.entity.Lease;
import com.carrentalsystem.exception.LeaseNotFoundException;

/**
 * The LeaseService class provides methods to interact with the lease repository
 * and perform operations related to leases in the car rental system.
 */
public class LeaseService implements ILeaseService {
	private ICarLeaseRepositoryImpl leaseDao;

	/**
	 * Constructs a new LeaseService object with the default lease repository
	 * implementation.
	 */
	public LeaseService() {
		this.leaseDao = new ICarLeaseRepositoryImpl();
	}

	/**
	 * Creates a new lease in the system.
	 *
	 * @param leaseID    The ID of the lease
	 * @param vehicleID  The ID of the vehicle leased
	 * @param customerID The ID of the customer leasing the vehicle
	 * @param startDate  The start date of the lease
	 * @param endDate    The end date of the lease
	 * @param type       The type of lease (e.g., daily, monthly)
	 * @param state      The state of the lease (e.g., active, expired)
	 */
	@Override
	public void createLease(int leaseID, int vehicleID, int customerID, Date startDate, Date endDate, String type,
			String state) {
		Lease lease = new Lease(leaseID, vehicleID, customerID, startDate, endDate, type, state);
		try {
			leaseDao.createLease(lease);
			System.out.println("Lease created successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns a leased car and completes the lease.
	 *
	 * @param leaseID The ID of the lease to return
	 * @return A list of leases containing the returned lease
	 * @throws LeaseNotFoundException if the lease with the specified ID is not
	 *                                found
	 */
	@Override
	public List<Lease> returnCar(int leaseID) throws LeaseNotFoundException {
		try {
			return leaseDao.returnCar(leaseID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Lists all active leases in the system.
	 *
	 * @return A list of active leases
	 */
	@Override
	public List<Lease> listActiveLeases() {
		try {
			return leaseDao.listActiveLeases();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Lists the lease history in the system.
	 *
	 * @return A list of lease history
	 */
	@Override
	public List<Lease> listLeaseHistory() {
		try {
			return leaseDao.listLeaseHistory();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Calculates the cost of a lease.
	 *
	 * @param leaseID The ID of the lease
	 * @return The calculated cost of the lease
	 */
	@Override
	public double calculateLeaseCost(int leaseID) {
		try {
			return leaseDao.calculateLeaseCost(leaseID);
		} catch (SQLException | LeaseNotFoundException e) {
			e.printStackTrace();
			return 0.0;
		}
	}
}

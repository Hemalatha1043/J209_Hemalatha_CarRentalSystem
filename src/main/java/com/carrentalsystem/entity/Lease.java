/**
 * The com.carrentalsystem.entity package contains the Lease class.
 */
package com.carrentalsystem.entity;

import java.util.Date;

/**
 * The Lease class represents a lease in a car rental system. It encapsulates
 * information such as lease ID, vehicle ID, customer ID, start date, end date,
 * lease type, and lease state.
 */
public class Lease {
	private int leaseID; // The unique identifier for the lease
	private int vehicleID; // The unique identifier for the vehicle
	private int customerID; // The unique identifier for the customer
	private Date startDate; // The start date of the lease
	private Date endDate; // The end date of the lease
	private String type; // The type of lease (e.g., daily, monthly)
	private String state; // The state of the lease (e.g., active, expired)

	/**
	 * Constructs a Lease object with the specified parameters.
	 * 
	 * @param leaseID    The unique identifier for the lease
	 * @param vehicleID  The unique identifier for the vehicle
	 * @param customerID The unique identifier for the customer
	 * @param startDate  The start date of the lease
	 * @param endDate    The end date of the lease
	 * @param type       The type of lease (e.g., daily, monthly)
	 * @param state      The state of the lease (e.g., active, expired)
	 */
	public Lease(int leaseID, int vehicleID, int customerID, Date startDate, Date endDate, String type, String state) {
		super();
		this.leaseID = leaseID;
		this.vehicleID = vehicleID;
		this.customerID = customerID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.state = state;
	}
	/**
	 * Constructs a new Lease object with default values.
	 */

	public Lease() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retrieves the lease ID.
	 * 
	 * @return The lease ID
	 */
	public int getLeaseID() {
		return leaseID;
	}

	/**
	 * Sets the lease ID.
	 * 
	 * @param leaseID The lease ID to set
	 */
	public void setLeaseID(int leaseID) {
		this.leaseID = leaseID;
	}

	/**
	 * Retrieves the vehicle ID associated with the lease.
	 * 
	 * @return The vehicle ID
	 */
	public int getVehicleID() {
		return vehicleID;
	}

	/**
	 * Sets the vehicle ID associated with the lease.
	 * 
	 * @param vehicleID The vehicle ID to set
	 */
	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	/**
	 * Retrieves the customer ID associated with the lease.
	 * 
	 * @return The customer ID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * Sets the customer ID associated with the lease.
	 * 
	 * @param customerID The customer ID to set
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * Retrieves the start date of the lease.
	 * 
	 * @return The start date of the lease
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date of the lease.
	 * 
	 * @param startDate The start date of the lease to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Retrieves the end date of the lease.
	 * 
	 * @return The end date of the lease
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date of the lease.
	 * 
	 * @param endDate The end date of the lease to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Retrieves the type of the lease.
	 * 
	 * @return The type of the lease
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the lease.
	 * 
	 * @param type The type of the lease to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Retrieves the state of the lease.
	 * 
	 * @return The state of the lease
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state of the lease.
	 * 
	 * @param state The state of the lease to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Returns the string representation of the Lease object.
	 * 
	 * @return The string representation of the Leaseobject, including its lease ID,
	 *         vehicle ID, customer ID, start date, end date, type, and state.
	 */
	@Override
	public String toString() {
		return "Lease [leaseID=" + leaseID + ", vehicleID=" + vehicleID + ", customerID=" + customerID + ", startDate="
				+ startDate + ", endDate=" + endDate + ", type=" + type + ", state=" + state + "]";
	}
}

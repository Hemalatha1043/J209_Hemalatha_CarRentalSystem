package com.carrentalsystem.dao;

import com.carrentalsystem.util.DBConnection;

import java.util.Date;
import java.util.List;

import com.carrentalsystem.entity.Vehicle;
import com.carrentalsystem.entity.Customer;
import com.carrentalsystem.entity.Lease;
import com.carrentalsystem.entity.Payment;

import com.carrentalsystem.exception.CarNotFoundException;
import com.carrentalsystem.exception.CustomerNotFoundException;
import com.carrentalsystem.exception.LeaseNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class implements the {@link ICarLeaseRepository} interface to provide
 * methods for managing car rental operations in the database.
 */

public class ICarLeaseRepositoryImpl implements ICarLeaseRepository {

	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	/**
	 * Adds a new car to the database.
	 *
	 * @param car The car to be added
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public void addCar(Vehicle car) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getDBConn();
			stmt = con.createStatement();

			ps = con.prepareStatement(
					"INSERT INTO VEHICLE(vehicleID, make, model , year, dailyRate, status, passengerCapacity, engineCapacity) VALUES(?,?,?,?,?,?,?,?)");

			ps.setInt(1, car.getVehicleID());
			ps.setString(2, car.getMake());
			ps.setString(3, car.getModel());
			ps.setInt(4, car.getYear());
			ps.setFloat(5, car.getDailyRate());
			ps.setString(6, car.getStatus());
			ps.setInt(7, car.getPassengerCapacity());
			ps.setInt(8, car.getEngineCapacity());

			int noof = ps.executeUpdate();
			System.out.println(noof + " rows inserted");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}
	}

	/**
	 * Removes a car from the database based on the given car ID.
	 *
	 * @param carID The ID of the car to be removed
	 * @throws CarNotFoundException if the car with the given ID is not found
	 * @throws SQLException         if a database access error occurs
	 */
	@Override
	public void removeCar(int carID) throws CarNotFoundException, SQLException {

		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement("DELETE FROM VEHICLE WHERE VEHICLEID = ?");
			ps.setInt(1, carID);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Vehicle with ID " + carID + " has been successfully deleted.");

			} else {
				throw new CarNotFoundException("Car with ID " + carID + " not found.");
			}

		} catch (SQLException e) {

			System.out.println("not Removed!!");
			e.printStackTrace();

		} finally {
			closeResources(ps, rs);
		}
	}

	/**
	 * Retrieves a list of available cars from the database.
	 *
	 * @return A list of available cars
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public List<Vehicle> listAvailableCars() throws SQLException {
		List<Vehicle> availableCars = new ArrayList<>();
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement(
					"SELECT vehicleID, make, model , year, dailyRate, status, passengerCapacity, engineCapacity FROM Vehicle WHERE status = ?");
			ps.setString(1, "available");
			rs = ps.executeQuery();
			while (rs.next()) {
				int vehicleID = rs.getInt("vehicleID");
				String make = rs.getString("make");
				String model = rs.getString("model");
				int year = rs.getInt("year");
				float dailyRate = rs.getFloat("dailyRate");
				String status = rs.getString("status");
				int passengerCapacity = rs.getInt("passengerCapacity");
				int engineCapacity = rs.getInt("engineCapacity");
				Vehicle car = new Vehicle(vehicleID, make, model, year, dailyRate, status, passengerCapacity,
						engineCapacity);
				availableCars.add(car);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}

		return availableCars;
	}

	/**
	 * Retrieves a list of rented cars from the database.
	 *
	 * @return A list of rented cars
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public List<Vehicle> listRentedCars() throws SQLException {
		List<Vehicle> rentedcars = new ArrayList<>();
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement(
					"SELECT vehicleID, make, model , year, dailyRate, status, passengerCapacity, engineCapacity FROM Vehicle WHERE status = ?");
			ps.setString(1, "notavailable");
			rs = ps.executeQuery();
			while (rs.next()) {
				int vehicleID = rs.getInt("vehicleID");
				String make = rs.getString("make");
				String model = rs.getString("model");
				int year = rs.getInt("year");
				float dailyRate = rs.getFloat("dailyRate");
				String status = rs.getString("status");
				int passengerCapacity = rs.getInt("passengerCapacity");
				int engineCapacity = rs.getInt("engineCapacity");
				Vehicle car = new Vehicle(vehicleID, make, model, year, dailyRate, status, passengerCapacity,
						engineCapacity);
				rentedcars.add(car);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}

		return rentedcars;
	}

	/**
	 * Finds a car in the database based on the given car ID.
	 *
	 * @param carID The ID of the car to find
	 * @return The found car
	 * @throws CarNotFoundException if the car with the given ID is not found
	 * @throws SQLException         if a database access error occurs
	 */
	@Override
	public Vehicle findCarById(int carID) throws CarNotFoundException, SQLException {
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement(
					"SELECT vehicleID, make, model , year, dailyRate, status, passengerCapacity, engineCapacity FROM Vehicle WHERE vehicleID = ?");
			ps.setInt(1, carID);
			rs = ps.executeQuery();
			if (rs.next()) {
				int vehicleID = rs.getInt(1);
				String make = rs.getString(2);
				String model = rs.getString(3);
				int year = rs.getInt(4);
				float dailyRate = rs.getFloat(5);
				String status = rs.getString(6);
				int passengerCapacity = rs.getInt(7);
				int engineCapacity = rs.getInt(8);
				return new Vehicle(vehicleID, make, model, year, dailyRate, status, passengerCapacity, engineCapacity);
			} else {
				throw new CarNotFoundException("Car with ID " + carID + " not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeResources(ps, rs);
		}
		return null;

	}

	/**
	 * Adds a new customer to the database.
	 *
	 * @param customer The customer to be added
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public void addCustomer(Customer customer) throws SQLException {
		try {
			con = DBConnection.getDBConn();
			stmt = con.createStatement();

			ps = con.prepareStatement(
					"INSERT INTO CUSTOMER (firstName, lastName, email, phoneNumber) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPhoneNumber());

			int noof = ps.executeUpdate();
			System.out.println(noof + " rows inserted");

			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int generatedId = rs.getInt(1);
				customer.setCustomerID(generatedId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}
	}

	/**
	 * Removes a customer from the database based on the given customer ID.
	 *
	 * @param customerID The ID of the customer to be removed
	 * @throws CustomerNotFoundException if the customer with the given ID is not
	 *                                   found
	 * @throws SQLException              if a database access error occurs
	 */
	@Override
	public void removeCustomer(int customerID) throws CustomerNotFoundException, SQLException {

		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement("DELETE FROM CUSTOMER WHERE CUSTOMERID = ? ");
			ps.setInt(1, customerID);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Customer with ID " + customerID + " has been successfully deleted.");

			} else {
				throw new CustomerNotFoundException("Customer with ID " + customerID + " not found.");
			}

		} catch (SQLException e) {

			System.out.println("not Removed!!");
			e.printStackTrace();

		} finally {
			closeResources(ps, rs);
		}

	}

	/**
	 * Retrieves a list of customers from the database.
	 *
	 * @return A list of customers
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public List<Customer> listCustomers() throws SQLException {
		List<Customer> customers = new ArrayList<>();
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement("SELECT CustomerID, firstName, lastName, email, phoneNumber FROM Customer");
			rs = ps.executeQuery();
			while (rs.next()) {
				int CustomerID = rs.getInt("CustomerID");
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String Email = rs.getString("Email");
				String phoneNumber = rs.getString("phoneNumber");
				Customer customer = new Customer(CustomerID, FirstName, LastName, Email, phoneNumber);
				customers.add(customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}

		return customers;
	}

	/**
	 * Finds a customer in the database based on the given customer ID.
	 *
	 * @param customerID The ID of the customer to find
	 * @return The found customer
	 * @throws CustomerNotFoundException if the customer with the given ID is not
	 *                                   found
	 * @throws SQLException              if a database access error occurs
	 */
	@Override
	public Customer findCustomerById(int customerID) throws CustomerNotFoundException, SQLException {
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement(
					"SELECT CustomerID, firstName, lastName, email, phoneNumber FROM Customer WHERE customerID = ?");
			ps.setInt(1, customerID);
			rs = ps.executeQuery();
			if (rs.next()) {
				int customerId = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				String phoneNumber = rs.getString(5);
				return new Customer(customerId, firstName, lastName, email, phoneNumber);
			} else {
				throw new CustomerNotFoundException("Customer with ID " + customerID + " not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeResources(ps, rs);
		}
		return null;
	}

	/**
	 * Updates customer information in the database.
	 *
	 * @param customer The updated customer information
	 * @throws CustomerNotFoundException if the customer with the given ID is not
	 *                                   found
	 * @throws SQLException              if a database access error occurs
	 */
	@Override
	public void updateCustomer(Customer customer) throws CustomerNotFoundException, SQLException {
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement(
					"UPDATE Customer SET firstName = ?, lastName = ?, email = ?, phoneNumber = ? WHERE customerID = ?");
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPhoneNumber());
			ps.setInt(5, customer.getCustomerID());

			int rs = ps.executeUpdate();
			if (rs == 0) {
				throw new CustomerNotFoundException("Customer with ID " + customer.getCustomerID() + " not found.");
			}
		} finally {
			closeResources(ps, rs);
		}

	}

	/**
	 * Creates a new lease in the database.
	 *
	 * @param lease The lease to be created
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public void createLease(Lease lease) throws SQLException {
		if (lease.getStartDate() == null || lease.getEndDate() == null) {
			throw new IllegalArgumentException("startDate or endDate is null");
		}
		try {
			con = DBConnection.getDBConn();
			stmt = con.createStatement();
			ps = con.prepareStatement(
					"INSERT INTO LEASE (leaseID, vehicleID, customerID, startDate, endDate, type, state) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, lease.getLeaseID());
			ps.setInt(2, lease.getVehicleID());
			ps.setInt(3, lease.getCustomerID());

			if (lease.getStartDate() != null && lease.getEndDate() != null) {
				ps.setDate(4, new java.sql.Date(lease.getStartDate().getTime()));
				ps.setDate(5, new java.sql.Date(lease.getEndDate().getTime()));
			} else {
				throw new IllegalArgumentException("startDate or endDate is null");
			}
			ps.setString(6, lease.getType());
			ps.setString(7, lease.getState());

			int noof = ps.executeUpdate();
			ps = con.prepareStatement("UPDATE Vehicle SET status = ? WHERE vehicleID = ?");
			ps.setString(1, "notavailable");
			ps.setInt(2, lease.getVehicleID());
			ps.executeUpdate();
			System.out.println(noof + " rows inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}

	}

	/**
	 * Marks a lease as expired in the database based on the given lease ID and
	 * updates the vehicle status to available.
	 *
	 * @param leaseID The ID of the lease to be returned
	 * @return The list of active leases after returning the car
	 * @throws LeaseNotFoundException if the lease with the given ID is not found
	 * @throws SQLException           if a database access error occurs
	 */
	@Override
	public List<Lease> returnCar(int leaseID) throws LeaseNotFoundException, SQLException {
		Lease lease = null;
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement("UPDATE Lease SET state = 'expired' WHERE leaseID = ?");
			ps.setInt(1, leaseID);

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				ps = con.prepareStatement(
						"UPDATE vehicle SET status = 'available' WHERE vehicleID = (select vehicleID from lease where leaseID=?)");
				ps.setInt(1, leaseID);
				ps.executeUpdate();
				System.out.println("Lease with ID " + leaseID + " has been successfully updated.");
				lease = getLeaseById(leaseID);
				if (lease == null) {
					throw new LeaseNotFoundException("Lease with ID " + leaseID + " not found after update.");
				}
			} else {
				throw new LeaseNotFoundException("Lease with ID " + leaseID + " not found.");
			}
		} finally {
			closeResources(ps, rs);
		}
		return null;

	}

	private Lease getLeaseById(int leaseID) throws LeaseNotFoundException {
		Lease lease = null;
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement("SELECT * FROM Lease WHERE leaseID = ?");
			ps.setInt(1, leaseID);
			rs = ps.executeQuery();
			if (rs.next()) {
				lease = new Lease(rs.getInt("leaseID"), rs.getInt("vehicleID"), rs.getInt("customerID"),
						rs.getDate("startDate"), rs.getDate("endDate"), rs.getString("type"), rs.getString("state"));

			} else {
				throw new LeaseNotFoundException("Lease with ID " + leaseID + " not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}
		return lease;
	}

	/**
	 * Checks if a lease with the given ID exists in the database.
	 *
	 * @param leaseID The ID of the lease to find
	 * @return true if the lease exists, otherwise false
	 * @throws LeaseNotFoundException if the lease with the given ID is not found
	 * @throws SQLException           if a database access error occurs
	 */
	@Override
	public boolean findLeaseById(int leaseID) throws LeaseNotFoundException, SQLException {
		Lease lease = null;
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement("SELECT * FROM Lease WHERE leaseID = ?");
			ps.setInt(1, leaseID);
			rs = ps.executeQuery();
			if (rs.next()) {
				lease = new Lease(rs.getInt("leaseID"), rs.getInt("vehicleID"), rs.getInt("customerID"),
						rs.getDate("startDate"), rs.getDate("endDate"), rs.getString("type"), rs.getString("state"));

			} else {
				throw new LeaseNotFoundException("Lease with ID " + leaseID + " not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}
		return true;
	}

	/**
	 * Retrieves a list of active leases from the database.
	 *
	 * @return A list of active leases
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public List<Lease> listActiveLeases() throws SQLException {
		List<Lease> activeLeases = new ArrayList<>();
		try {
			con = DBConnection.getDBConn();
			stmt = con.createStatement();
			ps = con.prepareStatement(
					"SELECT leaseID, vehicleID, customerID, startDate, endDate, type, state FROM Lease WHERE state = ?");
			ps.setString(1, "active");
			rs = ps.executeQuery();
			while (rs.next()) {
				int leaseID = rs.getInt("leaseID");
				int vehicleID = rs.getInt("vehicleID");
				int customerID = rs.getInt("customerID");
				Date startDate = rs.getDate("startDate");
				Date endDate = rs.getDate("endDate");
				String type = rs.getString("type");
				String state = rs.getString("state");

				Lease lease = new Lease(leaseID, vehicleID, customerID, startDate, endDate, type, state);
				activeLeases.add(lease);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}
		return activeLeases;
	}

	/**
	 * Retrieves a list of lease history from the database.
	 *
	 * @return A list of lease history
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public List<Lease> listLeaseHistory() throws SQLException {
		List<Lease> leaseHistory = new ArrayList<>();
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement(
					"SELECT leaseID, vehicleID, customerID, startDate, endDate, type, state FROM Lease");
			rs = ps.executeQuery();

			while (rs.next()) {
				int leaseID = rs.getInt("leaseID");
				int vehicleID = rs.getInt("vehicleID");
				int customerID = rs.getInt("customerID");
				Date startDate = rs.getDate("startDate");
				Date endDate = rs.getDate("endDate");
				String type = rs.getString("type");
				String state = rs.getString("state");

				Lease lease = new Lease(leaseID, vehicleID, customerID, startDate, endDate, type, state);
				leaseHistory.add(lease);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}
		return leaseHistory;
	}

	/**
	 * Calculates the total cost of the lease based on the given lease ID.
	 *
	 * @param leaseID The ID of the lease to calculate the cost for
	 * @return The total cost of the lease
	 * @throws SQLException           if a database access error occurs
	 * @throws LeaseNotFoundException if the lease with the given ID is not found
	 */
	@Override
	public double calculateLeaseCost(int leaseID) throws SQLException, LeaseNotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement("SELECT startDate, endDate, type, vehicleID FROM Lease WHERE leaseID = ?");
			ps.setInt(1, leaseID);
			rs = ps.executeQuery();

			if (rs.next()) {
				LocalDate startDate = rs.getDate("startDate").toLocalDate();
				LocalDate endDate = rs.getDate("endDate").toLocalDate();
				String type = rs.getString("type");
				int vehicleID = rs.getInt("vehicleID");

				float dailyRate = 0;

				PreparedStatement ps1 = con.prepareStatement("SELECT dailyRate FROM Vehicle WHERE vehicleID = ?");
				ps1.setInt(1, vehicleID);
				ResultSet vehicleRs = ps1.executeQuery();

				if (vehicleRs.next()) {
					dailyRate = vehicleRs.getFloat("dailyRate");
				}

				double totalCost = 0.0;

				if (type.equalsIgnoreCase("DailyLease")) {
					long durationInDays = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
					totalCost = dailyRate * durationInDays;

				} else if (type.equalsIgnoreCase("MonthlyLease")) {
					int startMonth = startDate.getMonthValue();
					int EndMonth = startDate.getMonthValue();
					if (startMonth == EndMonth) {
						long durationInDays = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
						totalCost = dailyRate * durationInDays;
					} else {
						long months = java.time.temporal.ChronoUnit.MONTHS.between(startDate, endDate);
						totalCost = dailyRate * (months + 1);

						LocalDate lastMonthStartDate = endDate.withDayOfMonth(1);
						long remainingDays = java.time.temporal.ChronoUnit.DAYS.between(lastMonthStartDate, endDate);
						totalCost += dailyRate * remainingDays;

					}

				}

				return totalCost;
			} else {
				throw new LeaseNotFoundException("Lease with ID " + leaseID + " not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			closeResources(ps, rs);
		}
	}

	/**
	 * Records a payment for a lease in the database.
	 *
	 * @param paymentID   The ID of the payment
	 * @param leaseID     The ID of the lease
	 * @param amount      The amount of the payment
	 * @param paymentDate The date of the payment
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public void recordPayment(int paymentID, int leaseID, float amount, java.util.Date paymentDate)
			throws SQLException {
		try {
			con = DBConnection.getDBConn();
			stmt = con.createStatement();

			ps = con.prepareStatement(
					"INSERT INTO Payment (paymentID, leaseID, paymentDate, amount) VALUES (?, ?, ?, ?)");

			ps.setInt(1, paymentID);
			ps.setInt(2, leaseID);
			ps.setDate(3, new java.sql.Date(paymentDate.getTime()));
			ps.setFloat(4, amount);
			int noof = ps.executeUpdate();
			System.out.println(noof + " rows inserted");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}
	}

	/**
	 * Retrieves the payment history for a customer from the database.
	 *
	 * @param customerID The ID of the customer
	 * @return A list of payment history
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public List<Payment> retrievePaymentHistory(int customerID) throws SQLException {
		List<Payment> paymentHistory = new ArrayList<>();
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement(
					"SELECT paymentID, leaseID, paymentDate, amount FROM Payment WHERE leaseID IN (SELECT leaseID FROM Lease WHERE customerID = ?)");
			ps.setInt(1, customerID);
			rs = ps.executeQuery();
			while (rs.next()) {
				int paymentID = rs.getInt("paymentID");
				int leaseID = rs.getInt("leaseID");
				Date paymentDate = rs.getDate("paymentDate");
				float amount = rs.getFloat("amount");
				Payment payment = new Payment(paymentID, leaseID, paymentDate, amount);
				paymentHistory.add(payment);
			}
		} finally {
			closeResources(ps, rs);
		}
		return paymentHistory;
	}

	/**
	 * Calculates the total revenue from all payments in the database.
	 *
	 * @return The total revenue
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public double calculateTotalRevenue() throws SQLException {
		double totalRevenue = 0.0;
		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement("SELECT SUM(amount) AS totalRevenue FROM Payment");
			rs = ps.executeQuery();
			if (rs.next()) {
				totalRevenue = rs.getDouble("totalRevenue");
			}
		} finally {
			closeResources(ps, rs);
		}
		return totalRevenue;
	}

	/**
	 * Adds a new car to the database for testing purposes.
	 *
	 * @param car The car to be added
	 * @return true if the car is successfully added, otherwise false
	 * @throws SQLException if a database access error occurs
	 */
	public boolean addCarTest(Vehicle car) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getDBConn();
			stmt = con.createStatement();

			ps = con.prepareStatement(
					"INSERT INTO VEHICLE(vehicleID, make, model , year, dailyRate, status, passengerCapacity, engineCapacity) VALUES(?,?,?,?,?,?,?,?)");

			ps.setInt(1, car.getVehicleID());
			ps.setString(2, car.getMake());
			ps.setString(3, car.getModel());
			ps.setInt(4, car.getYear());
			ps.setFloat(5, car.getDailyRate());
			ps.setString(6, car.getStatus());
			ps.setInt(7, car.getPassengerCapacity());
			ps.setInt(8, car.getEngineCapacity());

			int noof = ps.executeUpdate();
			System.out.println(noof + " rows inserted");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeResources(ps, rs);
		}
		return true;
	}

	/**
	 * Creates a new lease in the database for testing purposes.
	 *
	 * @param lease The lease to be created
	 * @return true if the lease is successfully created, otherwise false
	 * @throws SQLException if a database access error occurs
	 */
	public boolean createLeaseTest(Lease lease) throws SQLException {
		if (lease.getStartDate() == null || lease.getEndDate() == null) {
			throw new IllegalArgumentException("startDate or endDate is null");
		}

		try {
			con = DBConnection.getDBConn();
			ps = con.prepareStatement(
					"INSERT INTO Lease (leaseID, vehicleID, customerID, startDate, endDate, type, state) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, lease.getLeaseID());
			ps.setInt(2, lease.getVehicleID());
			ps.setInt(3, lease.getCustomerID());
			ps.setDate(4, new java.sql.Date(lease.getStartDate().getTime()));
			ps.setDate(5, new java.sql.Date(lease.getEndDate().getTime()));

			if (!Arrays.asList("DailyLease", "MonthlyLease").contains(lease.getType())) {
				throw new IllegalArgumentException("Invalid lease type");
			}
			ps.setString(6, lease.getType());

			if (!Arrays.asList("active", "expired").contains(lease.getState())) {
				throw new IllegalArgumentException("Invalid lease state");
			}
			ps.setString(7, lease.getState());

			int noof = ps.executeUpdate();

			ps = con.prepareStatement("UPDATE Vehicle SET status = ? WHERE vehicleID = ?");
			ps.setString(1, "notavailable");
			ps.setInt(2, lease.getVehicleID());
			ps.executeUpdate();

			System.out.println(noof + " rows inserted");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e; // Rethrow the exception to indicate failure
		} finally {
			closeResources(ps, rs);
		}

		return true;
	}

	/**
	 * Closes the PreparedStatement and ResultSet resources.
	 *
	 * @param ps The PreparedStatement to close
	 * @param rs The ResultSet to close
	 */
	private void closeResources(PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

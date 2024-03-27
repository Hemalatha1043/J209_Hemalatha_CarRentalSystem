/**
 * This class represents the main module of the Car Rental System application.
 */
package com.carrentalsystem.main;

import com.carrentalsystem.controller.CustomerService;

import com.carrentalsystem.dao.ICarLeaseRepository;
import com.carrentalsystem.dao.ICarLeaseRepositoryImpl;
import com.carrentalsystem.entity.Vehicle;
import com.carrentalsystem.entity.Customer;
import com.carrentalsystem.entity.Lease;
import com.carrentalsystem.entity.Payment;
import com.carrentalsystem.exception.CarNotFoundException;
import com.carrentalsystem.exception.CustomerNotFoundException;
import com.carrentalsystem.exception.LeaseNotFoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * MainModule class provides the main functionality and user interface of the
 * Car Rental System application.
 */
public class MainModule {
	static Scanner scanner = new Scanner(System.in);
	private static ICarLeaseRepository carLeaseRepository = new ICarLeaseRepositoryImpl();

	/**
	 * The main method that starts the Car Rental System application.
	 *
	 * @param args The command line arguments
	 * @throws SQLException              if a database access error occurs
	 * @throws ParseException            if an error occurs during parsing
	 * @throws CustomerNotFoundException if the customer is not found
	 */
	public static void main(String[] args) throws SQLException, ParseException, CustomerNotFoundException {

		boolean exit = false;
		while (!exit) {
			System.out.println("********** Car Rental System **********");
			System.out.println("1. Vehicle");
			System.out.println("2. Customer");
			System.out.println("3. Lease");
			System.out.println("4. Payment");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("1. Add new car");
				System.out.println("2. Remove car");
				System.out.println("3. List available cars");
				System.out.println("4. List rented cars");
				System.out.println("5. Find car by ID");
				System.out.print("Enter your choice: ");
				int choiceVehicleOperation = scanner.nextInt();
				scanner.nextLine();
				switch (choiceVehicleOperation) {
				case 1:
					addNewCar();
					break;
				case 2:
					removeCar();
					break;
				case 3:
					listAvailableCars();
					break;
				case 4:
					listRentedCars();
					break;
				case 5:
					findCarById();
					break;
				default:
					System.out.println("Invalid choice! Please enter a number between 1 and 5.");
				}

				break;
			case 2:
				System.out.println("1. Add new customer");
				System.out.println("2. Update customer");
				System.out.println("3. Remove customer");
				System.out.println("4. List customers");
				System.out.println("5. Find customer by ID");
				System.out.print("Enter your choice: ");
				int choiceCustomerOperation = scanner.nextInt();
				scanner.nextLine();
				switch (choiceCustomerOperation) {
				case 1:
					addNewCustomer();
					break;
				case 2:
					updateCustomer();
					break;
				case 3:
					removeCustomer();
					break;
				case 4:
					listCustomers();
					break;
				case 5:
					findCustomerById();
					break;
				default:
					System.out.println("Invalid choice! Please enter a number between 1 and 5.");
				}
				break;
			case 3:
				System.out.println("1. Create lease");
				System.out.println("2. Return car");
				System.out.println("3. Find lease by ID");
				System.out.println("4. List active leases");
				System.out.println("5. List lease history");
				System.out.println("6. Calculate Lease Cost");
				System.out.print("Enter your choice: ");
				int choiceLeaseOperation = scanner.nextInt();
				scanner.nextLine();
				switch (choiceLeaseOperation) {

				case 1:
					createLease();
					break;
				case 2:
					returnCar();
					break;
				case 3:
					findLeaseById();
					break;
				case 4:
					listActiveLeases();
					break;
				case 5:
					listLeaseHistory();
					break;
				case 6:
					calculateLeaseCost();
					break;
				default:
					System.out.println("Invalid choice! Please enter a number between 1 and 6.");
				}
				break;
			case 4:

				System.out.println("1. Record payment");
				System.out.println("2. Calculate Total Revenue");
				System.out.println("3. Retrieve Payment History");
				System.out.print("Enter your choice: ");
				int choicePaymentOperation = scanner.nextInt();
				scanner.nextLine();
				switch (choicePaymentOperation) {
				case 1:
					recordPayment();
					break;
				case 2:
					calculateTotalRevenue();
					break;
				case 3:
					retrievePaymentHistory();
					break;
				default:
					System.out.println("Invalid choice! Please enter a number between 1 and 3.");
				}
				break;
			case 5:
				exit = true;
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid choice! Please enter a number between 1 and 5.");
			}
		}
	}

	/**
	 * Method to add a new car to the database.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void addNewCar() throws SQLException {
		System.out.println("Enter car ID:");
		int carID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter make:");
		String make = scanner.nextLine();
		System.out.println("Enter model:");
		String model = scanner.nextLine();
		System.out.println("Enter year:");
		int year = scanner.nextInt();
		System.out.println("Enter daily rate:");
		float dailyRate = scanner.nextFloat();
		System.out.println("Enter passenger capacity:");
		int passengerCapacity = scanner.nextInt();
		System.out.println("Enter engine capacity:");
		int engineCapacity = scanner.nextInt();
		Vehicle car = new Vehicle(carID, make, model, year, dailyRate, "available", passengerCapacity, engineCapacity);
		carLeaseRepository.addCar(car);
		System.out.println("Car added successfully.");
	}

	/**
	 * Method to remove a car from the database.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void removeCar() throws SQLException {
		System.out.println("Enter car ID:");
		int carID = scanner.nextInt();
		try {
			carLeaseRepository.removeCar(carID);
			System.out.println("Car removed successfully.");
		} catch (CarNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Method to list available cars.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void listAvailableCars() throws SQLException {
		List<Vehicle> availableCars = carLeaseRepository.listAvailableCars();
		if (availableCars.isEmpty()) {
			System.out.println("No available cars.");
		} else {
			System.out.println("Available Cars:");
			for (Vehicle car : availableCars) {
				System.out.println(car.toString());
			}
		}
	}

	/**
	 * Method to list rented cars.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void listRentedCars() throws SQLException {
		List<Vehicle> rentedCars = carLeaseRepository.listRentedCars();
		if (rentedCars.isEmpty()) {
			System.out.println("No rented cars.");
		} else {
			System.out.println("Rented Cars:");
			for (Vehicle car : rentedCars) {
				System.out.println(car.toString());
			}
		}
	}

	/**
	 * Method to find a car by its ID.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void findCarById() throws SQLException {
		System.out.println("Enter car ID:");
		int carID = scanner.nextInt();
		try {
			Vehicle car = carLeaseRepository.findCarById(carID);
			if (car != null) {
				System.out.println("Car found: " + car);

			} else {
				System.out.println("Car with ID " + carID + " not found.");
			}
		} catch (CarNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Method to add a new customer to the database.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void addNewCustomer() throws SQLException {
		System.out.println("Enter first name:");
		String firstName = scanner.nextLine();
		System.out.println("Enter last name:");
		String lastName = scanner.nextLine();
		System.out.println("Enter email:");
		String email = scanner.nextLine();
		System.out.println("Enter phone number:");
		String phoneNumber = scanner.nextLine();
		CustomerService customerService = new CustomerService();
		customerService.addCustomer(firstName, lastName, email, phoneNumber);

	}

	/**
	 * Method to remove a customer from the database.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void removeCustomer() throws SQLException {
		System.out.println("Enter customer ID:");
		int customerID = scanner.nextInt();
		try {
			carLeaseRepository.removeCustomer(customerID);
			System.out.println("Customer removed successfully.");
		} catch (CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Method to list all customers.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void listCustomers() throws SQLException {
		List<Customer> customers = carLeaseRepository.listCustomers();
		if (customers.isEmpty()) {
			System.out.println("No customers.");
		} else {
			System.out.println("Customers:");
			for (Customer customer : customers) {
				System.out.println(customer.toString());
			}
		}
	}

	/**
	 * Method to find a customer by ID.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void findCustomerById() throws SQLException {
		System.out.println("Enter customer ID:");
		int customerID = scanner.nextInt();
		try {
			Customer customer = carLeaseRepository.findCustomerById(customerID);
			System.out.println("Customer found: " + customer);
		} catch (CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Method to update customer information.
	 *
	 * @throws SQLException              if a database access error occurs
	 * @throws CustomerNotFoundException if the customer is not found
	 */
	private static void updateCustomer() throws SQLException, CustomerNotFoundException {
		System.out.println("Enter customer ID:");
		int customerID = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.println("Enter updated first name:");
		String firstName = scanner.nextLine();
		System.out.println("Enter updated last name:");
		String lastName = scanner.nextLine();
		System.out.println("Enter updated email:");
		String email = scanner.nextLine();
		System.out.println("Enter updated phone number:");
		String phoneNumber = scanner.nextLine();
		Customer updatedCustomer = new Customer(customerID, firstName, lastName, email, phoneNumber);
		carLeaseRepository.updateCustomer(updatedCustomer);
		System.out.println("Customer details updated successfully.");
	}

	/**
	 * Method to create a new lease.
	 *
	 * @throws ParseException if an error occurs during parsing
	 * @throws SQLException   if a database access error occurs
	 */
	private static void createLease() throws ParseException, SQLException {
		System.out.println("Enter lease ID:");
		int leaseID = scanner.nextInt();
		System.out.println("Enter customer ID:");
		int customerID = scanner.nextInt();
		List<Vehicle> availableCars = carLeaseRepository.listAvailableCars();
		System.out.println("Select any one of the vehicleID listed");
		for(Vehicle v : availableCars) {
			System.out.println(v.toString());
		}
		System.out.println("Enter car ID:");
		int carID = scanner.nextInt();
		boolean carFound = false;
		for (Vehicle car : availableCars) {
		    if (car.getVehicleID() == carID) {
		        carFound = true;
		        break;
		    }
		}
		if(carFound) {
		System.out.println("Enter start date (yyyy-MM-dd):");
		String startDateStr = scanner.next();
		System.out.println("Enter end date (yyyy-MM-dd):");
		String endDateStr = scanner.next();
		System.out.println("Enter choice");
		System.out.println("1: DailyLease");
		System.out.println("2: MonthlyLease");
		int choice = scanner.nextInt();
		String type;
		switch (choice) {
		case 1:
			type = "DailyLease";
			break;
		case 2:
			type = "MonthlyLease";
			break;
		default:
			System.out.println("Invalid choice.");
			return;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = dateFormat.parse(startDateStr);
		Date endDate = dateFormat.parse(endDateStr);
		String state = "active";
		try {
			// java.util.Date startDate = startdate;
			// java.util.Date endDate = enddate;
			Lease lease = new Lease(leaseID, carID, customerID, startDate, endDate, type, state);
			carLeaseRepository.createLease(lease);
			System.out.println("Lease created successfull ");
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid date format. Please use yyyy-MM-dd.");
		}
		}
		else {
		    System.out.println("Car with ID " + carID + " does not exist in the list of available cars.");

		}
	}

	/**
	 * Method to mark a lease as returned.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void returnCar() throws SQLException {
		System.out.println("Enter lease ID:");
		int leaseID = scanner.nextInt();
		try {
			carLeaseRepository.returnCar(leaseID);
			System.out.println("Car returned successfully.");
		} catch (LeaseNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Method to find a lease by its ID.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void findLeaseById() throws SQLException {
		System.out.println("Enter lease ID:");
		int leaseID = scanner.nextInt();
		try {
			boolean lease = carLeaseRepository.findLeaseById(leaseID);
			System.out.println("Lease found: " + lease);
		} catch (LeaseNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Method to list all active leases.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void listActiveLeases() throws SQLException {
		List<Lease> activeLeases = carLeaseRepository.listActiveLeases();
		if (activeLeases.isEmpty()) {
			System.out.println("No active leases.");
		} else {
			System.out.println("Active Leases:");
			for (Lease lease : activeLeases) {
				System.out.println(lease.toString());
			}
		}
	}

	/**
	 * Method to list lease history.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void listLeaseHistory() throws SQLException {
		List<Lease> leaseHistory = carLeaseRepository.listLeaseHistory();
		if (leaseHistory.isEmpty()) {
			System.out.println("No lease history.");
		} else {
			System.out.println("Lease History:");
			for (Lease lease : leaseHistory) {
				System.out.println(lease.toString());
			}
		}
	}

	/**
	 * Method to calculate the lease cost.
	 *
	 * @return The calculated lease cost
	 */
	private static double calculateLeaseCost() {
		double leaseCost = 0.0;
		try {
			System.out.println("Enter LeaseID: ");
			int leaseID = scanner.nextInt();
			leaseCost = carLeaseRepository.calculateLeaseCost(leaseID);
			System.out.println(" Total Lease Cost for Lease ID " + leaseID + ": " + leaseCost);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (LeaseNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return leaseCost;
	}

	/**
	 * Method to record a payment.
	 *
	 * @throws SQLException   if a database access error occurs
	 * @throws ParseException if an error occurs during parsing
	 */
	private static void recordPayment() throws SQLException, ParseException {
		System.out.println("Enter payment ID:");
		int paymentID = scanner.nextInt();
		System.out.println("Enter lease ID:");
		int leaseID = scanner.nextInt();
		System.out.println("Enter payment amount:");
		float amount = scanner.nextFloat();
		System.out.println("Enter paymentDate (yyyy-MM-dd):");
		String paymentDateStr = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date paymentdate = dateFormat.parse(paymentDateStr);
		try {
			java.sql.Date paymentDate = new java.sql.Date(paymentdate.getTime());
			carLeaseRepository.recordPayment(paymentID, leaseID, amount, paymentDate);
			System.out.println("Payment recorded successfully.");
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid date format. Please use yyyy-MM-dd.");
		}
	}

	/**
	 * Method to calculate the total revenue.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void calculateTotalRevenue() throws SQLException {
		double totalRevenue = carLeaseRepository.calculateTotalRevenue();
		System.out.println("Total Revenue: " + totalRevenue);
	}

	/**
	 * Method to retrieve payment history.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	private static void retrievePaymentHistory() throws SQLException {
		System.out.println("Enter Customer ID:");
		int customerID = scanner.nextInt();
		List<Payment> payments = carLeaseRepository.retrievePaymentHistory(customerID);
		if (payments.isEmpty()) {
			System.out.println("No payments found for this customer.");
		} else {
			System.out.println("Payment History for Customer ID " + customerID + ":");
			for (Payment payment : payments) {
				System.out.println(payment.toString());
			}
		}
	}
}

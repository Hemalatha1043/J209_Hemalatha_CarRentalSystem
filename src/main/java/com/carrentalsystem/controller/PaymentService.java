package com.carrentalsystem.controller;

import com.carrentalsystem.dao.ICarLeaseRepositoryImpl;
import com.carrentalsystem.entity.Payment;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * PaymentService class provides methods to handle payment-related operations in the Car Rental System.
 */
public class PaymentService implements IPaymentService {
    private ICarLeaseRepositoryImpl paymentDao;

    /**
     * Constructs a PaymentService object with the default constructor.
     */
    public PaymentService() {
        this.paymentDao = new ICarLeaseRepositoryImpl();
    }

    /**
     * Records a payment for a lease.
     *
     * @param paymentID   The ID of the payment.
     * @param leaseID     The ID of the lease.
     * @param amount      The amount of the payment.
     * @param paymentDate The date of the payment.
     */
    @Override
    public void recordPayment(int paymentID, int leaseID, float amount, Date paymentDate) {
        try {
            paymentDao.recordPayment(paymentID, leaseID, amount, paymentDate);
            System.out.println("Payment recorded successfully.");
        } catch (SQLException e) {
            System.err.println("Error recording payment: " + e.getMessage());
        }
    }

    /**
     * Retrieves the payment history for a customer.
     *
     * @param customerID The ID of the customer.
     */
    @Override
    public void retrievePaymentHistory(int customerID) {
        try {
            List<Payment> paymentHistory = paymentDao.retrievePaymentHistory(customerID);
            System.out.println("Payment History for Customer ID: " + customerID);
            for (Payment payment : paymentHistory) {
                System.out.println(payment.toString());
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving payment history: " + e.getMessage());
        }
    }

    /**
     * Calculates the total revenue from payments.
     *
     * @return The total revenue.
     */
    @Override
    public double calculateTotalRevenue() {
        try {
            double totalRevenue = paymentDao.calculateTotalRevenue();
            System.out.println("Total Revenue from Payments: $" + totalRevenue);
            return totalRevenue;
        } catch (SQLException e) {
            System.err.println("Error calculating total revenue: " + e.getMessage());
            return 0.0;
        }
    }
}

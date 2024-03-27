package com.carrentalsystem.controller;

import java.util.Date;

/**
 * The IPaymentService interface defines the contract for payment-related operations in the Car Rental System.
 */
public interface IPaymentService {

    /**
     * Records a payment for a lease.
     *
     * @param paymentID   The ID of the payment.
     * @param leaseID     The ID of the lease.
     * @param amount      The amount of the payment.
     * @param paymentDate The date of the payment.
     */
    void recordPayment(int paymentID, int leaseID, float amount, Date paymentDate);

    /**
     * Retrieves the payment history for a customer.
     *
     * @param customerID The ID of the customer.
     */
    void retrievePaymentHistory(int customerID);

    /**
     * Calculates the total revenue from payments.
     *
     * @return The total revenue.
     */
    double calculateTotalRevenue();

}

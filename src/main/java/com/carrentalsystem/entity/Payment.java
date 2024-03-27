/**
 * The com.carrentalsystem.entity package contains the Payment class.
 */
package com.carrentalsystem.entity;

import java.util.Date;

/**
 * The Payment class represents a payment made in a car rental system. It
 * encapsulates information such as payment ID, lease ID, payment date, and
 * amount.
 */
public class Payment {
	private int paymentID; // The unique identifier for the payment
	private int leaseID; // The lease identifier associated with the payment
	private Date paymentDate; // The date when the payment was made
	private float amount; // The amount of the payment

	/**
	 * Constructs a Payment object with the specified parameters.
	 * 
	 * @param paymentID   The unique identifier for the payment
	 * @param leaseID     The lease identifier associated with the payment
	 * @param paymentDate The date when the payment was made
	 * @param amount      The amount of the payment
	 */
	public Payment(int paymentID, int leaseID, Date paymentDate, float amount) {
		super();
		this.paymentID = paymentID;
		this.leaseID = leaseID;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	/**
	 * Retrieves the payment ID.
	 * 
	 * @return The payment ID
	 */
	public int getPaymentID() {
		return paymentID;
	}

	/**
	 * Sets the payment ID.
	 * 
	 * @param paymentID The payment ID to set
	 */
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	/**
	 * Retrieves the lease ID associated with the payment.
	 * 
	 * @return The lease ID
	 */
	public int getLeaseID() {
		return leaseID;
	}

	/**
	 * Sets the lease ID associated with the payment.
	 * 
	 * @param leaseID The lease ID to set
	 */
	public void setLeaseID(int leaseID) {
		this.leaseID = leaseID;
	}

	/**
	 * Retrieves the payment date.
	 * 
	 * @return The payment date
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * Sets the payment date.
	 * 
	 * @param paymentDate The payment date to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * Retrieves the amount of the payment.
	 * 
	 * @return The payment amount
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * Sets the amount of the payment.
	 * 
	 * @param amount The payment amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/**
	 * Returns the string representation of the Payment object.
	 * 
	 * @return The string representation of the Payment object
	 */
	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", leaseID=" + leaseID + ", paymentDate=" + paymentDate + ", amount="
				+ amount + "]";
	}
}

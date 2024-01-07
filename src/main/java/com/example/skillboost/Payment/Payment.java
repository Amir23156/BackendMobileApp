package com.example.skillboost.Payment;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
public class Payment {

    @Id
    private String paymentID; // Changed from PaymentID to paymentID
    private double amount;
    private String paymentDate;

    // Constructors
    public Payment(String paymentID, double amount, String paymentDate) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // Getters and Setters
    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    // Method to process payment
    public void processPayment() {
        // Implement the logic for processing a payment
        System.out.println("Payment processed successfully!");
        System.out.println("Payment ID: " + paymentID);
        System.out.println("Amount: " + amount);
        System.out.println("Payment Date: " + paymentDate);
    }

    public static void main(String[] args) {
        // Example usage
        Payment payment = new Payment("ABC123", 100.0, "2023-01-01");
        payment.processPayment();
    }
}


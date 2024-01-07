package com.example.skillboost.Payment;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PaymentRepository extends MongoRepository<Payment, String> {

    // Find a payment by ID
    Optional<Payment> findById(String paymentID);

    // Find a payment by amount (assuming amounts are unique)
    Payment findByAmount(double amount);

    // Additional custom queries can be added based on your requirements

    // Example:
    // List<Payment> findByPaymentDate(String paymentDate);
}


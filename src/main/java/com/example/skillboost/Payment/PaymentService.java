package com.example.skillboost.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment findPaymentById(String paymentID) {
        return paymentRepository.findById(paymentID).orElse(null);
    }

    public void deletePaymentById(String paymentID) {
        Optional<Payment> paymentOptional = paymentRepository.findById(paymentID);
        paymentOptional.ifPresent(paymentRepository::delete);
        // Additional logic if needed
    }

    public Payment updatePayment(String paymentID, Payment updatedPayment) {
        Optional<Payment> existingPaymentOptional = paymentRepository.findById(paymentID);
        if (existingPaymentOptional.isPresent()) {
            Payment existingPayment = existingPaymentOptional.get();
            // Update necessary fields using setters
            existingPayment.setAmount(updatedPayment.getAmount());
            existingPayment.setPaymentDate(updatedPayment.getPaymentDate());

            return paymentRepository.save(existingPayment);
        } else {
            // Handle the case when the payment with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate action.
            return null;
        }
    }
}


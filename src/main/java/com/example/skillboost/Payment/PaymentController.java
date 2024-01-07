package com.example.skillboost.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/processPayment")
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
        // Set any default values or perform necessary business logic
        return new ResponseEntity<>(paymentService.processPayment(payment), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAllPayments")
    public ResponseEntity<List<Payment>> findAllPayments() {
        return new ResponseEntity<>(paymentService.findAllPayments(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findPaymentById/{paymentID}")
    public ResponseEntity<?> findPaymentById(@PathVariable String paymentID) {
        Payment payment = paymentService.findPaymentById(paymentID);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            String errorMessage = "Payment with ID '" + paymentID + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @DeleteMapping("/deletePayment/{paymentID}")
    public ResponseEntity<String> deletePaymentById(@PathVariable String paymentID) {
        paymentService.deletePaymentById(paymentID);
        return new ResponseEntity<>("Payment with ID " + paymentID + " deleted", HttpStatus.OK);
    }

    @PutMapping("/updatePayment/{paymentID}")
    public ResponseEntity<Payment> updatePayment(@PathVariable String paymentID, @RequestBody Payment updatedPayment) {
        Payment existingPayment = paymentService.findPaymentById(paymentID);
        if (existingPayment != null) {
            // Update necessary fields using setters
            existingPayment.setAmount(updatedPayment.getAmount());
            existingPayment.setPaymentDate(updatedPayment.getPaymentDate());

            Payment savedPayment = paymentService.processPayment(existingPayment);
            return new ResponseEntity<>(savedPayment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


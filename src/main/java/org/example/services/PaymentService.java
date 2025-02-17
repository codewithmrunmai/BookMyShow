package org.example.services;


public class PaymentService {
    public boolean processPayment(double amount) {
        System.out.println("💳 Processing payment of ₹" + amount + "...");
        // Simulate success
        return true;
    }
}

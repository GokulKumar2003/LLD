package org.example.strategies.payment;

public class DebitCardPaymentStrategy implements PaymentStrategy {
    public void pay(double amount){
        System.out.println("Paid "+amount+" using Debit Card");
    }
}

package org.example.strategies.payment;

public class UPIPaymentStrategy implements PaymentStrategy{

    public void pay(double amount){
        System.out.println("Paid "+amount+" using UPI");
    }
}

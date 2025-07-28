package org.example.state;

import org.example.ATM;

public class IdleState implements ATMState{
    @Override
    public void insertCard(ATM atm, String cardNumber) {

    }

    @Override
    public void enterPin(ATM atm, String pin) {
        System.out.println("Please insert a Card");
    }

    @Override
    public void selectOperation(ATM atm, OperationType type) {
        System.out.println("Please insert a Card");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Please insert a Card");
    }
}

package org.example.state;

public interface ATMState {

    void insertCard(ATM atm, String cardNumber);
    void enterPin(ATM atm, String pin);
    void selectOperation(ATM atm, OperationType type);
    void ejectCard(ATM atm);
}

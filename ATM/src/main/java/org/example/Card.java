package org.example;

public class Card {

    private String cardId;
    private String pin;
    private String accountNumber;

    public Card(String cardId, String pin, String accountNumber) {
        this.cardId = cardId;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

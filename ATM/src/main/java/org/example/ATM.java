package org.example;

import jdk.incubator.vector.VectorOperators;
import org.example.state.ATMState;
import org.example.state.IdleState;

import java.util.HashMap;
import java.util.Map;

public class ATM {

    private static ATM instance;
    private Card card;
    private ATMState state;
    private Map<Integer, Integer> cash;
    private final BankService bankService;

    private ATM(){
        this.state = new IdleState();
        this.bankService = new BankService();
        cash = new HashMap<>();
    }

    public static ATM getInstance(){
        if(instance == null){
            synchronized (ATM.class){
                if(instance == null){
                    instance = new ATM();
                }
            }
        }
        return instance;
    }

    public void changeState(ATMState state){
        this.state = state;
    }

    public void insertCard(String cardNumber){
        state.insertCard(this, cardNumber);
    }

    public void enterPin(String pin){
        state.enterPin(this, pin);
    }

    public void selectOperation(OperationType type){
        state.selectOperation(this, type);
    }

    
}

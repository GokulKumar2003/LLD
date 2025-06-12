package org.example.splittype;

import org.example.User;

public class EqualSplit extends Split{

    public EqualSplit(User user){
        super(user);
    }

    @Override
    public double getAmount(){
        return amount;
    }

    public void setAmount(){
        this.amount = amount;
    }
}

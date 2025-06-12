package org.example.splittype;

import org.example.User;

public class PercentageSplit extends Split{

    private final double percent;

    public PercentageSplit(User user, double percent){
        super(user);
        this.percent = percent;
    }

    @Override
    public double getAmount(){
        return amount;
    }

    public double getPercent(){
        return percent;
    }

}

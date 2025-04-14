package org.example;

public class NormalChargingStrategy implements ChargingStrategy{

    @Override
    public double calculateCharge(String vehcileType,
                                  DurationType durationType, int duration){
        switch (vehcileType){
            case "bike":
                return durationType == DurationType.days ? duration*50*24 :
                        duration*50;
            case "car":
                return durationType == DurationType.days ? duration*100*24 :
                        duration*100;
            case "truck":
                return durationType == DurationType.days ? duration*150*24 :
                        duration*150;
        }

        return 0;
    }
}

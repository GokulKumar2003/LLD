package org.example;

public class PeakHourChargingStrategy implements ChargingStrategy{

    @Override
    public double calculateCharge(String vehcileType,
                                  DurationType durationType, int duration){
        switch (vehcileType){
            case "bike":
                return durationType == DurationType.days ? duration*75*24 :
                        duration*75;
            case "car":
                return durationType == DurationType.days ? duration*150*24 :
                        duration*150;
            case "truck":
                return durationType == DurationType.days ? duration*200*24 :
                        duration*200;
        }

        return 0;
    }
}

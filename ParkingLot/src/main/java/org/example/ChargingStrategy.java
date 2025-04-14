package org.example;

public interface ChargingStrategy {

    public double calculateCharge(String vehicleType, DurationType durationType,
                                  int duration);
}

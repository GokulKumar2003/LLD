package org.example.Spot;

import org.example.ChargingStrategy;

public class CarParkingSpot extends ParkingSpot{

    public CarParkingSpot(int spotId, boolean isReserved, ChargingStrategy chargingStrategy){
        super(spotId, isReserved, chargingStrategy);
    }
}

package org.example.Spot;

import org.example.ChargingStrategy;

public class BikeParkingSpot extends ParkingSpot{

    public BikeParkingSpot(int spotId, boolean isReserved,
                           ChargingStrategy chargingStrategy){
        super(spotId, isReserved, chargingStrategy);
    }
}

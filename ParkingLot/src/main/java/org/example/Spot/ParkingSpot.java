package org.example.Spot;

import org.example.ChargingStrategy;

import java.time.LocalDate;
import java.util.Date;

public abstract class ParkingSpot {

    private int spotId;
    private boolean isReserved;
    private Date occupiedAt;
    private ChargingStrategy chargingStrategy;

    public ParkingSpot(int spotId, boolean isReserved, ChargingStrategy chargingStrategy) {
        this.spotId = spotId;
        this.isReserved = isReserved;
        this.chargingStrategy = chargingStrategy;
        System.out.println(chargingStrategy.getClass());
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public Date getOccupiedAt() {
        return occupiedAt;
    }

    public void setOccupiedAt(Date occupiedAt) {
        this.occupiedAt = occupiedAt;
    }

    public ChargingStrategy getChargingStrategy() {
        return chargingStrategy;
    }

    public void setChargingStrategy(ChargingStrategy chargingStrategy) {
        this.chargingStrategy = chargingStrategy;
        System.out.println(this.chargingStrategy.getClass());
    }
}

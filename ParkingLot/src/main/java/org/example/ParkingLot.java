package org.example;

import org.example.Spot.ParkingSpot;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Map<String, List<ParkingSpot>> spots; // vehicleType --> spots

    public ParkingLot(Map<String, List<ParkingSpot>> spots){
        this.spots = spots;
    }

    /* returns spot id*/
    public int parkVehicle(String vehicleType, ChargingStrategy chargingStrategy){
        if(!spots.containsKey(vehicleType)){
            return -1;
        }
        ParkingSpot spot = findAvailableSpot(vehicleType);
        if(spot == null){
            return -1;
        }

        int spotId = spot.getSpotId();
        spot.setReserved(true);
        spot.setOccupiedAt(new Date());
        spot.setChargingStrategy(chargingStrategy);

        return spotId;
    }

    public ParkingSpot findAvailableSpot(String vehicleType){
        List<ParkingSpot> spotsList = spots.get(vehicleType);

        Iterator<ParkingSpot> iterator = spotsList.iterator();
        while (iterator.hasNext()){
            ParkingSpot spot = iterator.next();
            if(!spot.isReserved()){
                return spot;
            }
        }
        return null;
    }

    public boolean unParkVehicle(String vehicleType, int spotId){
        ParkingSpot spot = getSpotFromSpots(vehicleType, spotId);
        spot.setReserved(false);
        return true;
    }

    public double getCharge(String vehicleType,
                            DurationType durationType, int spotId){
        ParkingSpot spot = getSpotFromSpots(vehicleType, spotId);
        if(spot == null){
            return 0;
        }
        Date start = spot.getOccupiedAt();
        Date end = new Date();
        int duration = 0;
        switch (durationType){
            case DurationType.hours:
                duration =
                        (int)(end.getTime() - start.getTime())/(1000*60*60) + 1;
            case DurationType.days:
                duration =
                        (int)(end.getTime() - start.getTime())/(1000*60*60*24) + 1;
        }

        double charge = spot.getChargingStrategy().calculateCharge(vehicleType,
                durationType, duration);
        return charge;
    }
     public ParkingSpot getSpotFromSpots(String vehicleType, int spotId){
           List<ParkingSpot> spotList = spots.get(vehicleType);

           Iterator<ParkingSpot> iterator = spotList.iterator();
           while(iterator.hasNext()){
               ParkingSpot spot = iterator.next();
               if(spot.getSpotId() == spotId){
                   return spot;
               }
           }
           return null;
     }
}

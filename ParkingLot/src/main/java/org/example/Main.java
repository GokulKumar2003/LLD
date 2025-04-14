package org.example;

import org.example.Spot.BikeParkingSpot;
import org.example.Spot.CarParkingSpot;
import org.example.Spot.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, List<ParkingSpot>> spots = new HashMap<>();
        List<ParkingSpot> carSpots = new ArrayList<>();
        ChargingStrategy chargingStrategy = new NormalChargingStrategy();
        carSpots.add(new CarParkingSpot(1, false, chargingStrategy));
        carSpots.add(new CarParkingSpot(2, false, chargingStrategy));
        carSpots.add(new CarParkingSpot(3, false, chargingStrategy));

        List<ParkingSpot> bikeSpots = new ArrayList<>();
        bikeSpots.add(new BikeParkingSpot(4, false, chargingStrategy));
        bikeSpots.add(new BikeParkingSpot(5, false, chargingStrategy));

        spots.put("car", carSpots);
        spots.put("bike", bikeSpots);

        ParkingLot parkingLot = new ParkingLot(spots);

        int spotId1 = parkingLot.parkVehicle("car", chargingStrategy);
        System.out.println("Spot Id: "+spotId1);
        int spotId2 = parkingLot.parkVehicle("bike", chargingStrategy);
        System.out.println("Spot Id: "+spotId2);

        double charge1 = parkingLot.getCharge("car", DurationType.days, spotId1);
        System.out.println("Charges: "+charge1);
        parkingLot.unParkVehicle("car", spotId1);

        double charge2 = parkingLot.getCharge("bike", DurationType.days, spotId2);
        System.out.println("Charges: "+charge2);
        parkingLot.unParkVehicle("bike", spotId2);

        int spotId3 = parkingLot.parkVehicle("bike", new PeakHourChargingStrategy());
        System.out.println(spotId3);
        double charge3 = parkingLot.getCharge("bike", DurationType.hours, spotId3);
        System.out.println(charge3);
        parkingLot.unParkVehicle("bike", spotId3);

    }
}
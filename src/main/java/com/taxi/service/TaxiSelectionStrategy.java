package com.taxi.service;

import com.taxi.model.Location;
import com.taxi.model.Taxi;

import java.util.List;

public class TaxiSelectionStrategy {
    public Taxi selectTaxi(List<Taxi> taxis, Location pickupPoint, int pickupTime) {
        Taxi bestTaxi = null;
        int minEarnings = Integer.MAX_VALUE;
        int minDistance = Integer.MAX_VALUE;
        for (Taxi taxi : taxis) {
            if (taxi.getCurrentLocation() == pickupPoint && taxi.isTaxiAvailable(pickupPoint, pickupTime)) {
                if (bestTaxi == null) {
                    bestTaxi = taxi;
                }
            }
        }

        if (bestTaxi == null) {
            for (Taxi taxi : taxis) {
                if(taxi.getCurrentLocation().getDistance(pickupPoint) < minDistance && taxi.isTaxiAvailable(pickupPoint, pickupTime)
                || minEarnings > taxi.getTotalEarnings()) {
                    bestTaxi = taxi;
                    minEarnings = taxi.getTotalEarnings();
                }
                 
            }
        }

        if (bestTaxi != null) {
            System.out.println("\nTaxi can be allocated!");
        } else {
            System.out.println("\nNo taxi available for booking.");
        }

        return bestTaxi;
    }
}

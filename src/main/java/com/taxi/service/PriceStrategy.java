package com.taxi.service;

import com.taxi.constants.TaxiConstants;
import com.taxi.model.Location;

public class PriceStrategy {

    public static int calculateFare(Location pickupPoint, Location dropPoint) {
        int distance = pickupPoint.getDistance(dropPoint);
        return TaxiConstants.BASE_FARE +(Math.max(0,distance-TaxiConstants.MIN_DISTANCE_FOR_BASE_FARE)*TaxiConstants.PER_KM_RATE);
    }
}

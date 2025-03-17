package com.taxi.model;

import com.taxi.constants.TaxiConstants;
import com.taxi.service.PriceStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Booking {
    private UUID bookingId;
    private int customerId;
    private Location pickupPoint;
    private Location dropPoint;
    private int pickupTime;
    private int dropTime;
    private int fare;

    public Booking(int customerId, Location pickupPoint, Location dropPoint, int pickupTime) {
        this.bookingId = UUID.randomUUID();
        this.customerId = customerId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.dropTime =  calculateDropTime();
        this.fare = PriceStrategy.calculateFare(pickupPoint,dropPoint);
    }

    public int calculateDropTime() {
        int travelDistance = pickupPoint.getDistance(dropPoint);
        int travelTime = (travelDistance / TaxiConstants.DISTANCE_BETWEEN_POINTS) * TaxiConstants.TRAVEL_TIME_PER_POINT;
        int rawDropTime = pickupTime + (travelTime / 60);
        return rawDropTime % 24;
    }

}

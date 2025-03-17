package com.taxi.model;

import com.taxi.constants.TaxiConstants;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Taxi {
    private int id;
    private Location currentLocation;
    private int totalEarnings;
    private List<Booking> bookings;

    public Taxi(int id){
        this.id = id;
        this.totalEarnings = 0;
        this.currentLocation = TaxiConstants.INITIAL_LOCATION;
        this.bookings = new ArrayList<>();
    }

    public boolean isTaxiAvailable(Location pickupPoint, int pickupTime) {
        for (Booking booking : bookings) {
            if(booking.getDropTime() > pickupTime){
                return false;
            }
        }
        return currentLocation == pickupPoint;
    }

    public void assignBooking(Booking booking) {
        bookings.add(booking);
        this.totalEarnings += booking.getFare();
        this.currentLocation = booking.getDropPoint();
    }

}

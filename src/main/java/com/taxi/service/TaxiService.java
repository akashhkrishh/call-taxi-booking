package com.taxi.service;

import com.taxi.constants.TaxiConstants;
import com.taxi.model.Booking;
import com.taxi.model.Location;
import com.taxi.model.Taxi;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TaxiService {

    private final List<Taxi> taxis;
    private final TaxiSelectionStrategy taxiSelectionStrategy;

    public TaxiService(TaxiSelectionStrategy taxiSelectionStrategy) {
        this.taxiSelectionStrategy = taxiSelectionStrategy;
        taxis = new ArrayList<Taxi>();
        for(int i=1;i<=TaxiConstants.INITIAL_TAXI_COUNT;i++){
            Taxi taxi = new Taxi(i);
            taxis.add(taxi);
        }

    }

    public void bookTaxi(int customerId, Location pickupPoint, Location dropPoint, int pickTime) {
        Taxi selectedTaxi = taxiSelectionStrategy.selectTaxi(taxis,pickupPoint,pickTime);
        if(selectedTaxi==null){
            System.out.println("Taxi not found");
            return;
        }
        Booking booking = new Booking(customerId,pickupPoint,dropPoint,pickTime);
        selectedTaxi.assignBooking(booking);
        System.out.println("Taxi " + selectedTaxi.getId() + " allocated!");

    }

    public void displayTaxiDetails() {
        for (Taxi taxi : taxis) {
            if (!taxi.getBookings().isEmpty()) {
            System.out.printf("Taxi-%d    Total Earnings: Rs. %d%n", taxi.getId(), taxi.getTotalEarnings());
            System.out.println("+--------------------------------------+-------------+------+------+------------+----------+---------+");
            System.out.printf("| %-36s | %-11s | %-4s | %-4s | %-10s | %-8s | %-7s |%n",
                    "BookingID", "CustomerID", "From", "To", "PickupTime", "DropTime", "Amount");
            System.out.println("+--------------------------------------+-------------+------+------+------------+----------+---------+");
                for (Booking booking : taxi.getBookings()) {
                    System.out.printf("| %-36s | %-11d | %-4s | %-4s | %-10d | %-8d | Rs.%-4d |%n",
                            booking.getBookingId().toString(),
                            booking.getCustomerId(),
                            booking.getPickupPoint(),
                            booking.getDropPoint(),
                            booking.getPickupTime(),
                            booking.getDropTime(),
                            booking.getFare());
                }
                System.out.println("+--------------------------------------+-------------+------+------+------------+----------+---------+\n");
            }

        }
    }

}

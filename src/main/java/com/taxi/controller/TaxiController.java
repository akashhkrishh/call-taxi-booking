package com.taxi.controller;

import com.taxi.model.Location;
import com.taxi.service.TaxiService;

import java.util.Arrays;
import java.util.Scanner;

public class TaxiController {
    private final TaxiService taxiService;

    public TaxiController(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    public void bookTaxi(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the Customer ID: ");
        int customerId = sc.nextInt();
        System.out.print("Enter the Pickup Location"+ Arrays.toString(Location.values()) +": ");
        Location pickupLocation = Location.valueOf(sc.next());
        System.out.print("Enter the Drop Location"+ Arrays.toString(Location.values()) +": ");
        Location dropLocation = Location.valueOf(sc.next());
        System.out.print("Enter the Pickup Time: ");
        int pickupTime = sc.nextInt();
        if(pickupLocation==dropLocation){
            System.out.println("\n\nPickup Location and Drop Location cannot be the same!");
        }else {
            taxiService.bookTaxi(customerId, pickupLocation, dropLocation, pickupTime);
        }
    }

    public void displayTaxiDetails() {
        taxiService.displayTaxiDetails();
    }

}

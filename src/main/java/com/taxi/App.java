package com.taxi;

import com.taxi.controller.TaxiController;
import com.taxi.model.Location;
import com.taxi.service.TaxiSelectionStrategy;
import com.taxi.service.TaxiService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TaxiSelectionStrategy taxiSelectionStrategy = new TaxiSelectionStrategy();
        TaxiService taxiService = new TaxiService(taxiSelectionStrategy);
        TaxiController  taxiController = new TaxiController(taxiService);
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n1.Book Taxi\n2.Display Taxi Details\n3.Exit");
            System.out.print("Choose an option: ");
            switch(sc.nextInt()) {
                case 1: taxiController.bookTaxi(); break;
                case 2: taxiController.displayTaxiDetails(); break;
                case 3: System.exit(0); break;
                default: System.out.println("Invalid option!"); break;
            }
        }

    }


}
package org.personal;

import org.personal.model.Flight;
import org.personal.repositories.FlightRepository;
import org.personal.searchStrategy.CheapestStrategy;
import org.personal.searchStrategy.MinimumHopsStrategy;
import org.personal.services.FlightSearchService;
import org.personal.services.FlightService;

import java.util.List;
import java.util.Scanner;

import static org.personal.OutputDisplayer.printFlights;

public class Main {


    public static void main(String[] args) {
        FlightSystem flightSystem = new FlightSystem();


        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            flightSystem.processInput(input);
        }

//        flightService.addFlight("A", "B", "Airline1", 100);
//        flightService.addFlight("B", "C", "Airline2", 50);
//        flightService.addFlight("A", "C", "Airline1", 200);


    }
}
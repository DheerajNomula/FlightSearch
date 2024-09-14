package org.personal;

import java.util.Scanner;

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
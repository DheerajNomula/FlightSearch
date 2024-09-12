package org.personal;

import org.personal.model.Flight;

import java.util.List;

public class OutputDisplayer {

    public static void printFlights(List<Flight> flightList) {
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
    }
}

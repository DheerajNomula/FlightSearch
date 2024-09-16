package org.personal.repositories;

import org.personal.model.Flight;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FlightRepository {

    List<Flight> flightList;
    HashMap<String, List<Flight>> srcFlightsMap; // key -> source,

    // key -> source + dest -> list of flights

    public FlightRepository() {
        flightList = new LinkedList<>();
        srcFlightsMap = new HashMap<>();
    }

    public Flight createFlight(Flight flight) {
        srcFlightsMap.putIfAbsent(flight.getSource(), new LinkedList<>());
        srcFlightsMap.get(flight.getSource()).add(flight);
        flightList.add(flight);
        return flight;
    }

    public List<Flight> getFlights(String src) {
        return srcFlightsMap.get(src);
    }

    public HashMap<String, List<Flight>> getSrcFlightsMap() {
        return srcFlightsMap;
    }

    public void showFlights() {
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
    }
}

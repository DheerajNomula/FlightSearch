package org.personal.services;

import org.personal.ApiException;
import org.personal.model.Flight;
import org.personal.repositories.FlightRepository;

import java.util.HashMap;
import java.util.List;

public class FlightService {
    FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public static void validateFlight(String src, String dest, String airline, double price) {
        if (price <= 0)
            throw new ApiException("Price should be greater than 0");
        if (src.length() != 3)
            throw new ApiException("Source length should be equal to 3");
        if (dest.length() != 3)
            throw new ApiException("Destination length should be equal to 3");
        if (airline.length() < 3)
            throw new ApiException("Destination length should be greater than 3");
    }

    public Flight addFlight(String src, String dest, String airline, double price) {
        validateFlight(src, dest, airline, price);
        return flightRepository.createFlight(new Flight(src, dest, airline, price));
    }

    public HashMap<String, List<Flight>> getFlightMap() {
        return flightRepository.getSrcFlightsMap();
    }

    public void display() {
        flightRepository.showFlights();
    }
}

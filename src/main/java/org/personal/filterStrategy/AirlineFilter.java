package org.personal.filterStrategy;

import org.personal.model.Flight;

public class AirlineFilter implements FilterStrategy {
    private String airline;

    public AirlineFilter(String airline) {
        this.airline = airline;
    }

    @Override
    public boolean filter(Flight flight) {
        return airline.isEmpty() || flight.getAirline().equals(airline);
    }
}

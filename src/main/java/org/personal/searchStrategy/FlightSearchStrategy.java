package org.personal.searchStrategy;

import org.personal.filterStrategy.FilterStrategy;
import org.personal.model.Flight;

import java.util.HashMap;
import java.util.List;

public interface FlightSearchStrategy {
    List<Flight> searchFlights(HashMap<String, List<Flight>> graph, String source, String destination, FilterStrategy filterStrategy);
}

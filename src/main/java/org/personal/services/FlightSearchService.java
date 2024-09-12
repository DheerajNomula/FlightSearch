package org.personal.services;

import org.personal.filterStrategy.FilterStrategy;
import org.personal.model.Flight;
import org.personal.searchStrategy.FlightSearchStrategy;

import java.util.HashMap;
import java.util.List;

public class FlightSearchService {
    private FlightSearchStrategy searchStrategy;
    private FilterStrategy filter;

    public FlightSearchService setSearchStrategy(FlightSearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
        return this;
    }

    public FlightSearchService setFilterStrategy(FilterStrategy filterStrategy) {
        this.filter = filterStrategy;
        return this;
    }

    public List<Flight> searchFlights(HashMap<String, List<Flight>> graph, String source, String destination) {
        return searchStrategy.searchFlights(graph, source, destination, filter);
    }
}

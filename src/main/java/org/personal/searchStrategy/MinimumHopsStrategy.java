package org.personal.searchStrategy;

import org.personal.filterStrategy.FilterStrategy;
import org.personal.model.Flight;

import java.util.*;

public class MinimumHopsStrategy implements FlightSearchStrategy {
    private List<Flight> bestPath;
    private int minHops;
    private HashMap<String, List<Flight>> graph;
    private FilterStrategy filter;

    private void dfs(HashMap<String, List<Flight>> graph, String currentCity, String destination,
                     List<Flight> currentPath, Set<String> visited, int hops) {
        if (currentCity.equals(destination)) {
            if (hops < minHops) {
                bestPath = new ArrayList<>(currentPath);
                minHops = hops;
            }
            return;
        }

        visited.add(currentCity);
        for (Flight flight : graph.getOrDefault(currentCity, Collections.emptyList())) {
            if (!visited.contains(flight.getDestination())) {
                currentPath.add(flight);
                dfs(graph, flight.getDestination(), destination, currentPath, visited, hops + 1);
                currentPath.remove(currentPath.size() - 1);
            }
        }
        visited.remove(currentCity);
    }

    @Override
    public List<Flight> searchFlights(HashMap<String, List<Flight>> graph, String source, String destination, FilterStrategy filter) {
        this.filter = filter;
        bestPath = new ArrayList<>();
        minHops = Integer.MAX_VALUE;
        this.graph = graph;

        Set<String> visited = new HashSet<>();
        dfs(graph, source, destination, new ArrayList<>(), visited, 0);

        return bestPath;
    }

}

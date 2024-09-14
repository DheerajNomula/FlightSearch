package org.personal.searchStrategy;

import org.personal.filterStrategy.Filter;
import org.personal.model.Flight;

import java.util.*;

public class CheapestStrategy implements FlightSearchStrategy {

    private List<Flight> bestPath;
    private double minCost;
    private HashMap<String, List<Flight>> graph;

    private Filter filter;


    private void dfs(String currentCity, String destination, LinkedList<Flight> currentPath, Set<String> visited, double currentCost) {
        if (currentCity.equals(destination)) {
            if (currentCost < minCost) {
                bestPath = new LinkedList<>(currentPath);
                minCost = currentCost;
            }
            return;
        }

        visited.add(currentCity);
        for (Flight flight : graph.getOrDefault(currentCity, Collections.emptyList())) {
            if (!visited.contains(flight.getDestination()) && filter.filter(flight)) {
                currentPath.add(flight);
                dfs(flight.getDestination(), destination, currentPath, visited, currentCost + flight.getPrice());
                currentPath.remove(currentPath.size() - 1);
            }
        }
        visited.remove(currentCity);
    }

    @Override
    public List<Flight> searchFlights(HashMap<String, List<Flight>> graph, String source, String destination, Filter filter) {
        this.filter = filter;
        bestPath = new ArrayList<>();
        minCost = Double.MAX_VALUE;
        this.graph = graph;

        Set<String> visited = new HashSet<>();
        dfs(source, destination, new LinkedList<>(), visited, 0.0);

        return bestPath;
    }

}

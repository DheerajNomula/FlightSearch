package org.personal;

import org.personal.filterStrategy.AirlineFilter;
import org.personal.filterStrategy.DefaultFilter;
import org.personal.model.Flight;
import org.personal.repositories.FlightRepository;
import org.personal.searchStrategy.CheapestStrategy;
import org.personal.searchStrategy.MinimumHopsStrategy;
import org.personal.services.FlightSearchService;
import org.personal.services.FlightService;

import java.util.List;
import java.util.Scanner;

public class FlightSystem {
    FlightRepository flightRepository;
    FlightService flightService;
    FlightSearchService flightSearchService;


    public FlightSystem() {
        flightRepository = new FlightRepository();
        flightService = new FlightService(flightRepository);
        flightSearchService = new FlightSearchService().setFilterStrategy(new DefaultFilter());
    }

    public void processInput(String input) {
        String[] parts = input.split("->");
        String command = parts[0].trim();

        switch (command) {
            case "register flight":
                handleRegisterFlight(parts);
                break;
            case "search flight":
                handleSearchFlight(parts);
                break;
            default:
                System.out.println("Invalid command");
        }
    }

    private void handleRegisterFlight(String[] parts) {
        String airline = parts[1].trim();
        String source = parts[2].trim();
        String destination = parts[3].trim();
        double price = Double.parseDouble(parts[4].trim());

        System.out.println(flightService.addFlight(airline, source, destination, price));
    }

    void print(List<Flight> flights) {
        if (flights.isEmpty()) System.out.println("No flights found");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    private void search(String source, String destination) {
        System.out.println("Cheapest Strategy");
        print(flightSearchService.setSearchStrategy(new CheapestStrategy()).searchFlights(flightRepository.getSrcFlightsMap(), source, destination));

        System.out.println("Minimum Hops");
        print(flightSearchService.setSearchStrategy(new MinimumHopsStrategy()).searchFlights(flightRepository.getSrcFlightsMap(), source, destination));
    }

    private void handleSearchFlight(String[] parts) {
        String source = parts[1].trim();
        String destination = parts[2].trim();

        if (parts.length == 3) {
            search(source, destination);
        } else if (parts.length == 4) {
            flightSearchService.setFilterStrategy(new AirlineFilter(parts[3].trim()));
            search(source, destination);
        } else {
            System.out.println("Invalid command");
        }
    }

    public static void main(String[] args) {
        FlightSystem flightSystem = new FlightSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            flightSystem.processInput(input);
        }
        scanner.close();
    }
}

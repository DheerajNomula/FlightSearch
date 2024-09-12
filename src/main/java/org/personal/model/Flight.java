package org.personal.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flight {
    private String source;
    private String destination;
    private String airline;
    private double price;

    public Flight(String source, String destination, String airline, double price) {
        this.source = source;
        this.destination = destination;
        this.airline = airline;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", airline='" + airline + '\'' +
                ", price=" + price +
                '}';
    }

    public String uniqueString() {
        return airline + "|" + source + "|" + destination;
    }

}

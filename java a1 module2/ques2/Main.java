import java.util.Scanner;

abstract class Flight {
    private String flightNumber;
    private String airline;
    private double fare;

    public Flight(String flightNumber, String airline, double fare) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.fare = fare;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public double getFare() {
        return fare;
    }

    public abstract double calculateFare();

    @Override
    public String toString() {
        return "Flight No: " + flightNumber +
               "\nAirline: " + airline +
               "\nFare: " + calculateFare();
    }
}

class DomesticFlight extends Flight {

    public DomesticFlight(String flightNumber, String airline, double fare) {
        super(flightNumber, airline, fare);
    }

    @Override
    public double calculateFare() {
        return getFare() + (getFare() * 0.10);
    }
}

class InternationalFlight extends Flight {

    public InternationalFlight(String flightNumber, String airline, double fare) {
        super(flightNumber, airline, fare);
    }

    @Override
    public double calculateFare() {
        return getFare() + (getFare() * 0.25);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split(",");

            String type = parts[0].trim();
            String flightNumber = parts[1].trim();
            String airline = parts[2].trim();
            double fare = Double.parseDouble(parts[3].trim());

            Flight flight;

            if (type.equalsIgnoreCase("Domestic")) {
                flight = new DomesticFlight(flightNumber, airline, fare);
            } else {
                flight = new InternationalFlight(flightNumber, airline, fare);
            }

            System.out.println(flight);
        }

        sc.close();
    }
}
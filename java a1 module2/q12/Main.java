import java.util.Scanner;

class Vehicle {
    protected String regNo;
    protected String brand;
    protected double baseRate;

    public Vehicle(String regNo, String brand, double baseRate) {
        this.regNo = regNo;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    public double calculateRent() {
        return baseRate;
    }

    public String getType() {
        return "Vehicle";
    }

    @Override
    public String toString() {
        return getType() + " " + regNo + " " + brand +
               " Rent: " + calculateRent();
    }
}

class Car extends Vehicle {

    public Car(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override
    public double calculateRent() {
        return baseRate * 1.5;
    }

    @Override
    public String getType() {
        return "Car";
    }
}

class Bike extends Vehicle {

    public Bike(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override
    public double calculateRent() {
        return baseRate * 1.2;
    }

    @Override
    public String getType() {
        return "Bike";
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
            String regNo = parts[1].trim();
            String brand = parts[2].trim();
            double baseRate = Double.parseDouble(parts[3].trim());

            Vehicle vehicle;

            if (type.equalsIgnoreCase("Car")) {
                vehicle = new Car(regNo, brand, baseRate);
            } else {
                vehicle = new Bike(regNo, brand, baseRate);
            }

            System.out.println(vehicle);
        }

        sc.close();
    }
}
import java.util.Scanner;

abstract class Loan {
    protected double principal;
    protected double rate;
    protected double time;

    public Loan(double principal, double time) {
        this.principal = principal;
        this.time = time;
    }

    public abstract double calculateInterest();
}

class HomeLoan extends Loan {

    public HomeLoan(double principal, double time) {
        super(principal, 8);
        this.time = time;
    }

    @Override
    public double calculateInterest() {
        return (principal * rate * time) / 100;
    }
}

class CarLoan extends Loan {

    public CarLoan(double principal, double time) {
        super(principal, 10);
        this.time = time;
    }

    @Override
    public double calculateInterest() {
        return (principal * rate * time) / 100;
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
            double principal = Double.parseDouble(parts[1].trim());
            double time = Double.parseDouble(parts[2].trim());

            Loan loan;

            if (type.equalsIgnoreCase("Home")) {
                loan = new HomeLoan(principal, time);
                System.out.println("Home Loan Interest: " + loan.calculateInterest());
            } else {
                loan = new CarLoan(principal, time);
                System.out.println("Car Loan Interest: " + loan.calculateInterest());
            }
        }

        sc.close();
    }
}
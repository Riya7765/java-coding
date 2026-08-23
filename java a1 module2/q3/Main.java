import java.util.Scanner;

class Employee {
    private String name;
    private String id;
    private double basicSalary;

    // Default constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(String name, String id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee " + name + " (" + id + ") Salary: " + calculateSalary();
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, String id, double basicSalary, double bonus) {
        super(name, id, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + bonus;
    }

    @Override
    public String toString() {
        return "Manager " + getName() + " (" + getId() + ") Salary: " + calculateSalary();
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
            String name = parts[1].trim();
            String id = parts[2].trim();
            double basicSalary = Double.parseDouble(parts[3].trim());

            Employee emp;

            if (type.equalsIgnoreCase("Employee")) {
                emp = new Employee(name, id, basicSalary);
            } else {
                double bonus = Double.parseDouble(parts[4].trim());
                emp = new Manager(name, id, basicSalary, bonus);
            }

            System.out.println(emp);
        }

        sc.close();
    }
}
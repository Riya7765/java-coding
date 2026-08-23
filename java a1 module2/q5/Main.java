import java.util.Scanner;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }
}

class Doctor extends Person {
    private String specialization;

    public Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    public String toString() {
        return super.toString() +
               "\nSpecialization: " + specialization;
    }
}

class Surgeon extends Doctor {
    private String surgeryType;

    public Surgeon(String name, int age, String specialization, String surgeryType) {
        super(name, age, specialization);
        this.surgeryType = surgeryType;
    }

    public String toString() {
        return super.toString() +
               "\nSurgery Type: " + surgeryType;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] parts = input.split(",");

        String name = parts[0].trim();
        int age = Integer.parseInt(parts[1].trim());
        String specialization = parts[2].trim();
        String surgeryType = parts[3].trim();

        Surgeon surgeon = new Surgeon(name, age, specialization, surgeryType);

        System.out.println(surgeon);

        sc.close();
    }
}
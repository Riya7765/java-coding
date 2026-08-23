import java.util.Scanner;

interface Device {
    void turnOn();
    void turnOff();
}

class Fan implements Device {

    @Override
    public void turnOn() {
        System.out.println("Fan is now ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is now OFF");
    }
}

class Light implements Device {

    @Override
    public void turnOn() {
        System.out.println("Light is now ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is now OFF");
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

            Device device;

            if (input.equalsIgnoreCase("Fan")) {
                device = new Fan();
            } else {
                device = new Light();
            }

            device.turnOn();
            device.turnOff();
        }

        sc.close();
    }
}
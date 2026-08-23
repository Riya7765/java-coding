import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Guest {
    private String name;
    private int age;
    private String idProof;

    public Guest(String name, int age, String idProof) {
        this.name = name;
        this.age = age;
        this.idProof = idProof;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + idProof;
    }
}

class Reservation {
    private String reservationId;
    private String roomType;
    private List<Guest> guests;

    public Reservation(String reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
        this.guests = new ArrayList<>();
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    @Override
    public String toString() {
        String result = "Reservation ID: " + reservationId +
                        " Room: " + roomType + "\n";
        result += "Guests:\n";

        for (Guest guest : guests) {
            result += guest + "\n";
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reservation details
        String[] reservationData = sc.nextLine().split(",");

        String reservationId = reservationData[0].trim();
        String roomType = reservationData[1].trim();
        int numberOfGuests = Integer.parseInt(reservationData[2].trim());

        Reservation reservation = new Reservation(reservationId, roomType);

        // Guest details
        for (int i = 0; i < numberOfGuests; i++) {
            String[] guestData = sc.nextLine().split(",");

            String name = guestData[0].trim();
            int age = Integer.parseInt(guestData[1].trim());
            String idProof = guestData[2].trim();

            Guest guest = new Guest(name, age, idProof);
            reservation.addGuest(guest);
        }

        System.out.println(reservation);

        sc.close();
    }
}
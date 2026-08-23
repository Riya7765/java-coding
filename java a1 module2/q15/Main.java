import java.util.Scanner;

class Passport {
    private String passportNo;
    private String issueDate;
    private String expiryDate;

    public Passport(String passportNo, String issueDate, String expiryDate) {
        this.passportNo = passportNo;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Passport: " + passportNo +
               " Issue: " + issueDate +
               " Expiry: " + expiryDate;
    }
}

class Citizen {
    private String name;
    private String dob;
    private String address;
    private Passport passport;

    public Citizen(String name, String dob, String address, Passport passport) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Citizen: " + name +
               " DOB: " + dob +
               " Address: " + address +
               "\n" + passport;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Citizen details
        String[] citizenData = sc.nextLine().split(",");

        String name = citizenData[0].trim();
        String dob = citizenData[1].trim();
        String address = citizenData[2].trim();

        // Passport details
        String[] passportData = sc.nextLine().split(",");

        String passportNo = passportData[0].trim();
        String issueDate = passportData[1].trim();
        String expiryDate = passportData[2].trim();

        Passport passport = new Passport(
            passportNo,
            issueDate,
            expiryDate
        );

        Citizen citizen = new Citizen(
            name,
            dob,
            address,
            passport
        );

        System.out.println(citizen);

        sc.close();
    }
}
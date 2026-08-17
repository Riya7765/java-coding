import java.util.Scanner;
public class VotingCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        System.out.print("Enter citizenship status (true/false): ");
        boolean citizen = sc.nextBoolean();
        if (age >= 18 && citizen) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }
}
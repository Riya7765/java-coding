import java.util.Scanner;

class Account {
    private String accNo;
    private String holderName;
    private double balance;

    public Account(String accNo, String holderName, double balance) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Account account = new Account("A101", "User", 0);

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");

            String operation = parts[0];

            if (operation.equalsIgnoreCase("deposit")) {
                double amount = Double.parseDouble(parts[1]);
                account.deposit(amount);

            } else if (operation.equalsIgnoreCase("withdraw")) {
                double amount = Double.parseDouble(parts[1]);
                account.withdraw(amount);

            } else if (operation.equalsIgnoreCase("getBalance")) {
                System.out.println("Balance: " + account.getBalance());
            }
        }

        sc.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class atm_inerface {

    private static String userId = "user123", userPin = "1234";
    private static double balance = 1000.0;
    private static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the ATM System");
        System.out.print("User ID: ");
        String enteredUserId = sc.nextLine();
        System.out.print("PIN: ");
        String enteredPin = sc.nextLine();

        if (!userId.equals(enteredUserId) || !userPin.equals(enteredPin)) {
            System.out.println("Invalid credentials. Exiting.");
            return;
        }

        while (true) {
            System.out.println("\n1. History 2. Withdraw 3. Deposit 4. Transfer 5. Quit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 ->
                    showHistory();
                case 2 ->
                    withdraw(sc);
                case 3 ->
                    deposit(sc);
                case 4 ->
                    transfer(sc);
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default ->
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : history) {
                System.out.println(transaction);
            }
        }
    }

    private static void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Withdrawn: $" + amount);
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private static void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            history.add("Deposited: $" + amount);
            System.out.println("Deposit successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void transfer(Scanner sc) {
        System.out.print("Enter recipient ID: ");
        String recipient = sc.next();
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Transferred $" + amount + " to " + recipient);
            System.out.println("Transfer successful. Remaining balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}

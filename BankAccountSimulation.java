// File: BankAccountSimulation.java

import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String name, String number, double initialBalance) {
        this.accountHolderName = name;
        this.accountNumber = number;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: ₹" + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount + " | New Balance: ₹" + balance);
            System.out.println("✅ Deposit successful. Current balance: ₹" + balance);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount + " | New Balance: ₹" + balance);
            System.out.println("✅ Withdrawal successful. Current balance: ₹" + balance);
        } else if (amount > balance) {
            System.out.println("❌ Insufficient funds!");
        } else {
            System.out.println("❌ Invalid withdrawal amount.");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("💰 Current balance: ₹" + balance);
    }

    // Display transaction history
    public void showTransactionHistory() {
        System.out.println("\n📜 Transaction History for " + accountHolderName + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an account
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String number = sc.nextLine();
        System.out.print("Enter Initial Balance: ₹");
        double initialBalance = sc.nextDouble();

        Account account = new Account(name, number, initialBalance);

        // Menu-driven system
        int choice;
        do {
            System.out.println("\n===== Bank Menu =====");
            System.out.println("1️⃣ Deposit");
            System.out.println("2️⃣ Withdraw");
            System.out.println("3️⃣ Check Balance");
            System.out.println("4️⃣ View Transaction History");
            System.out.println("5️⃣ Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmt = sc.nextDouble();
                    account.deposit(depositAmt);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmt = sc.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    account.showTransactionHistory();
                    break;

                case 5:
                    System.out.println("👋 Thank you for using our bank system!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}

import java.util.Scanner;

public class BankAccount {
    double balance;
    double previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(double amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(double amount) {
        if (amount != 0 && amount <= balance) {
            balance -= amount;
            previousTransaction = -amount;
        } else if (balance < amount) {
            System.out.println("Insufficient funds");
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrew " + Math.abs(previousTransaction));
        } else {
            System.out.println("No previous transaction");
        }
    }

    void menu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName + "!");
        System.out.println("Your Id:" + customerId);
        System.out.println("\n");
        System.out.println("a) Check balance");
        System.out.println("b) Deposit Amount");
        System.out.println("c) Withdraw Amount");
        System.out.println("d) Get Previous Transaction");
        System.out.println("e) Exit");

        do {
            System.out.println("******************************************");
            System.out.println("Enter your option: ");
            option = sc.next().charAt(0);
            System.out.println("******************************************");

            switch (option) {
                case 'a':
                    System.out.println("Your balance is " + balance);
                    break;
                case 'b':
                    System.out.println("Enter the amount to deposit: ");
                    double amount = sc.nextDouble();
                    deposit(amount);
                    break;
                case 'c':
                    System.out.println("Enter the amount to withdraw: ");
                    amount = sc.nextDouble();
                    withdraw(amount);
                    break;
                case 'd':
                    getPreviousTransaction();
                    break;
                case 'e':
                    System.out.println("........................................");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option != 'e');
        System.out.println("Thank you for banking with us!");

    }
}

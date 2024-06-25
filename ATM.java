import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private int balance;
    private List<String> transactionHistory;

    public ATM(int initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Transfer Funds");
        System.out.println("4. Check Balance");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");
        System.out.println("Choose the operation you want to perform:");
    }

    public void deposit(int amount) {
        System.out.println("Processing deposit...");
        balance += amount;
        System.out.println("Deposited: $" + amount);
        System.out.println("New Balance: $" + balance);
        transactionHistory.add("Deposited: $" + amount);
    }

    public void withdraw(int amount) {
        System.out.println("Processing withdrawal...");
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New Balance: $" + balance);
            transactionHistory.add("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient Balance. Withdrawal canceled.");
        }
    }

    public void transferFunds(ATM destination, int amount) {
        System.out.println("Processing fund transfer...");
        if (balance >= amount) {
            balance -= amount;
            destination.deposit(amount);
            System.out.println("Transfer successful.");
            transactionHistory.add("Transferred $" + amount + " to another account");
        } else {
            System.out.println("Insufficient Balance. Transfer canceled.");
        }
    }

    public void checkBalance() {
        System.out.println("Your Current Balance: $" + balance);
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        ATM atm1 = new ATM(10000);
        ATM atm2 = new ATM(5000); // Example of another ATM for transfer

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            atm1.displayMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: $");
                    int depositAmount = sc.nextInt();
                    atm1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    int withdrawAmount = sc.nextInt();
                    atm1.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to transfer: $");
                    int transferAmount = sc.nextInt();
                    atm1.transferFunds(atm2, transferAmount);
                    break;
                case 4:
                    atm1.checkBalance();
                    break;
                case 5:
                    atm1.viewTransactionHistory();
                    break;
                case 6:
                    System.out.println("Exiting ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        } while (choice != 6);

        sc.close();
    }
}

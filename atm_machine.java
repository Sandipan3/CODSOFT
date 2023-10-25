/*
 TASK 3
 ATM INTERFACE
1.Create a class to represent the ATM machine.
2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.
3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().
4. Create a class to represent the user's bank account, which stores the account balance.
5. Connect the ATM class with the user's bank account class to access and modify the account
balance.
6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions */

import java.util.Scanner;

// Interface for bank accounts
interface Account {
    double getBalance();

    void deposit(double amount);

    boolean withdraw(double amount);
}

// Bank account class implementing the Account interface
class BankAccount implements Account {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs" + amount);
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance");
            return false;
        }
    }
}

// ATM class
class ATM {
    /*
     the main logic lies here. It takes user input and performs task accordingly
     */
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            displayOptions();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: Rs" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: Rs");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Your deposit was successful.\n Thanks for using our service.");
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: Rs");
                    double withdrawAmount = sc.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Your transaction successful.\n Thanks for using our service.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
    }
}

public class atm_machine {
    public static void main(String[] args) {
        Account userAccount = new BankAccount(1000.0); // Initialize with a balance of Rs1000
        ATM atm = new ATM(userAccount);
        atm.run();
        
    }
}

package assignment;

//main class for the program

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank(null);
        int choice = 0;
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Get Account Details");
            System.out.println("6. Get All Accounts");
            System.out.println("7. Get All Transactions");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    System.out.print("Enter account type (SAVINGS/CURRENT): ");
                    String accountType = sc.next();
                    bank.createAccount(name, balance, accountType);
                case 2:
                    System.out.print("Enter account number: ");
                    int accountNumber = sc.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double amount = sc.nextDouble();
                    bank.deposit(accountNumber, amount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    amount = sc.nextDouble();
                    bank.withdraw(accountNumber, amount);
                    break;
                case 4:
                    System.out.print("Enter account number from which to transfer: ");
                    int fromAccountNumber = sc.nextInt();
                    System.out.print("Enter account number to which to transfer: ");
                    int toAccountNumber = sc.nextInt();
                    System.out.print("Enter amount to transfer: ");
                    amount = sc.nextDouble();
                    bank.transfer(fromAccountNumber, toAccountNumber, amount);
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextInt();
                    bank.getAccountDetails(accountNumber);
                    break;
                case 6:
                    bank.getAllAccounts();
                    break;
                case 7: 
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextInt();
                    bank.getAllTransactions(accountNumber);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 8);
        sc.close();
    }
}
                    



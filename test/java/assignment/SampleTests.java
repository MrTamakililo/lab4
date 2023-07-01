package assignment;

import java.util.Map;

public class SampleTests {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");

        // Create checking account
        CheckingAccount checkingAccount = new CheckingAccount("123456", 1000.0, "John Doe");
        bank.addAccount(checkingAccount);

        // Create savings account
        SavingsAccount savingsAccount = new SavingsAccount("987654", 2000.0, "Jane Smith", 2.5);
        bank.addAccount(savingsAccount);

        // Deposit money
        checkingAccount.deposit(500.0);
        savingsAccount.deposit(1000.0);

        // Write checks
        checkingAccount.writeCheck(1, 200.0);
        checkingAccount.writeCheck(2, 300.0);

        // Cash a check
        try {
            checkingAccount.cashCheck(1, savingsAccount);
        } catch (InsufficientFundsException | CheckNotFoundException e) {
            e.printStackTrace();
        }

        // Transfer money
        try {
            savingsAccount.transfer(checkingAccount, 500.0);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }

        // Get uncashed checks
        Map<Integer, Double> uncashedChecks = checkingAccount.getUncashedChecks();
        for (Map.Entry<Integer, Double> entry : uncashedChecks.entrySet()) {
            int checkNumber = entry.getKey();
            double amount = entry.getValue();
            System.out.println("Uncashed Check: " + checkNumber + ", Amount: " + amount);
        }

        // Get total assets of the bank
        double totalAssets = bank.getTotalAssets();
        System.out.println("Total Assets: " + totalAssets);

        // Get transaction history of the bank
        System.out.println("Transaction History:");
        for (Transaction transaction : bank.getTransactionHistory()) {
            System.out.println(transaction.getType() + " - " + transaction.getAmount() +
                    " - " + transaction.getAccountNumber() + " - " + transaction.getDestinationAccountNumber());
        }
    }
}

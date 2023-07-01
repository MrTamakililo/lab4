package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank(String name) {
        this.accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void removeAccount(String accountNumber) throws AccountNotFoundException {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
        } else {
            throw new AccountNotFoundException("Account not found.");
        }
    }

    public double getTotalAssets() {
        double totalAssets = 0;
        for (Account account : accounts.values()) {
            totalAssets += account.getBalance();
        }
        return totalAssets;
    }

    public List<Transaction> getTransactionHistory() {
        List<Transaction> transactionHistory = new ArrayList<>();
        for (Account account : accounts.values()) {
            transactionHistory.addAll(account.getTransactions());
        }
        return transactionHistory;
    }

    public void getAllTransactions(int accountNumber) {
    }

    public void getAllAccounts() {
    }

    public void getAccountDetails(int accountNumber) {
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
    }

    public void createAccount(String name, double balance, String accountType) {
    }

    public void deposit(int accountNumber, double amount) {
    }

    public void withdraw(int accountNumber, double amount) {
    }
}

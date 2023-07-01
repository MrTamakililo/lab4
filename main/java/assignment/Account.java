package assignment;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String Status = null;
    private String accountNumber;
    private double balance;
    protected String accountHolder;
    private AccountStatus accountStatus;
    private List<Transaction> transactions;

    public Account(String accountNumber, double balance, String accountHolder) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.accountStatus = AccountStatus.ACTIVE;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction(TransactionType.DEPOSIT, amount);
    }

    public abstract void withdraw(double amount) throws InsufficientFundsException;

    public abstract void transfer(Account destinationAccount, double amount) throws InsufficientFundsException;

    public double getAccountBalance() {
        return balance;
    }

    public void addTransaction(TransactionType type, double amount) {
        Transaction transaction = new Transaction(type, amount, accountNumber);
        transactions.add(transaction);
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}

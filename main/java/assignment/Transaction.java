package assignment;

public class Transaction {
    private TransactionType type;
    private double amount;
    private String accountNumber;
    private String destinationAccountNumber;
    private String time;

    public Transaction(TransactionType type, double amount, String accountNumber) {
        this.type = type;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.time = getCurrentTime();
    }

    public Transaction(TransactionType type, double amount, String accountNumber, String destinationAccountNumber) {
        this(type, amount, accountNumber);
        this.destinationAccountNumber = destinationAccountNumber;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public String getTime() {
        return time;
    }

    // Utility method to get the current time (dummy implementation)
    private String getCurrentTime() {
        // Replace with actual implementation to get the current time
        return "2023-07-01 10:00:00";
    }
}

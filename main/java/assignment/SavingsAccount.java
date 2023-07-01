package assignment;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, String accountHolder, double interestRate) {
        super(accountNumber, balance, accountHolder);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void applyInterest() {
        if (getAccountStatus() == AccountStatus.ACTIVE) {
            double interest = getBalance() * interestRate / 100;
            deposit(interest);
            addTransaction(TransactionType.DEPOSIT, interest);
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdraw'");
    }

    @Override
    public void transfer(Account destinationAccount, double amount) throws InsufficientFundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transfer'");
    }
}

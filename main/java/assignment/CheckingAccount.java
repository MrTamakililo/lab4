package assignment;

import java.util.HashMap;
import java.util.Map;

public class CheckingAccount extends Account {
    private Map<Integer, Double> uncashedChecks;

    public CheckingAccount(String accountNumber, double balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
        this.uncashedChecks = new HashMap<>();
    }

    public void writeCheck(int checkNumber, double amount) {
        if (getAccountStatus() == AccountStatus.ACTIVE) {
            double updatedBalance = getBalance() - amount;
            uncashedChecks.put(checkNumber, amount);
            setBalance(updatedBalance);
            addTransaction(TransactionType.CHECK_WRITTEN, amount);
        }
    }

    private void setBalance(double updatedBalance) {
    }

    public void cashCheck(int checkNumber, SavingsAccount savingsAccount) throws InsufficientFundsException, CheckNotFoundException {
        if (uncashedChecks.containsKey(checkNumber)) {
            double checkAmount = uncashedChecks.get(checkNumber);
            if (getBalance() >= checkAmount) {
                double updatedBalance = getBalance() - checkAmount;
                setBalance(updatedBalance);
                savingsAccount.deposit(checkAmount);
                addTransaction(TransactionType.CHECK_CASHED, checkAmount, savingsAccount.getAccountNumber());
                uncashedChecks.remove(checkNumber);
            } else {
                throw new InsufficientFundsException("Insufficient funds in the checking account.");
            }
        } else {
            throw new CheckNotFoundException("Check with number " + checkNumber + " not found.");
        }
    }

    public Map<Integer, Double> getUncashedChecks() {
        return uncashedChecks;
    }

    public void addTransaction(TransactionType type, double amount) {
        Transaction transaction = new Transaction(type, amount, getAccountNumber(), getAccountHolder());
        getTransactions().add(transaction);
    }

    private void addTransaction(TransactionType type, double amount, String destinationAccountNumber) {
        Transaction transaction = new Transaction(type, amount, getAccountNumber(), destinationAccountNumber);
        getTransactions().add(transaction);
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

    public void cashCheck(int checkNumber, CheckingAccount checkingAccount) throws InsufficientFundsException, CheckNotFoundException {
        if (uncashedChecks.containsKey(checkNumber)) {
            double checkAmount = uncashedChecks.get(checkNumber);
            if (getBalance() >= checkAmount) {
                double updatedBalance = getBalance() - checkAmount;
                setBalance(updatedBalance);
                checkingAccount.deposit(checkAmount);
                addTransaction(TransactionType.CHECK_CASHED, checkAmount, checkingAccount.getAccountNumber());
                uncashedChecks.remove(checkNumber);
            } else {
                throw new InsufficientFundsException("Insufficient funds in the checking account.");
            }
        } else {
            throw new CheckNotFoundException("Check with number " + checkNumber + " not found.");
        }
    }
}

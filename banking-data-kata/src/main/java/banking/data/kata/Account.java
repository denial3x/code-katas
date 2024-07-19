package banking.data.kata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private final List<Transaction> transactions = new ArrayList<>();

    public void deposit(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount to deposit must be positive.");

        Transaction transaction = createTransaction(BigDecimal.valueOf(amount));
        transactions.add(transaction);
    }

    public void withdraw(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount to withdraw must be positive.");

        Transaction transaction = createTransaction(BigDecimal.valueOf(-amount));
        transactions.add(transaction);
    }

    public String printStatement() {
        return "Account balance: " + calculateCurrentBalance();
    }

    private BigDecimal calculateCurrentBalance() {
        return transactions.stream().map(Transaction::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Transaction createTransaction(BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setBalance(calculateCurrentBalance().add(amount));
        transaction.setDate(new Date());
        return transaction;
    }
}

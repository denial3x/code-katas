package banking.data.kata;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private Date date;
    private BigDecimal amount;
    private BigDecimal balance;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

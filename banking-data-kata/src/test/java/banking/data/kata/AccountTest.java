package banking.data.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    @Test
    void shouldPrintCorrectStatement() {
        Account account = new Account();
        account.deposit(100);

        assertEquals("""
                Date        Amount  Balance
                24.12.2015   +500      500
                23.8.2016    -100      400
                """, account.printStatement());
    }
}
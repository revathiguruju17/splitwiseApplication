package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void shouldReturnStringInSpecificFormat() {
        Transaction transaction = new Transaction( "A", "B", new Money( 10 ) );
        String result = "A->B, 10.0";
        assertEquals( result, transaction.toString() );
    }

    @Test
    void shouldReturnTrueForTwoTransactionsHavingSameValue() {
        Transaction transaction1 = new Transaction( "A", "B", new Money( 10 ) );
        Transaction transaction2 = new Transaction( "A", "B", new Money( 10 ) );
        assertEquals( transaction1, transaction2 );
    }

    @Test
    void shouldReturnFalseForTwoTransactionsHavingDifferentValue() {
        Transaction transaction1 = new Transaction( "A", "B", new Money( 10 ) );
        Transaction transaction2 = new Transaction( "A", "C", new Money( 100 ) );
        assertNotEquals( transaction1, transaction2 );
    }
}

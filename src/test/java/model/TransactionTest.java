package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void shouldReturnOneTransactionOfFriendsHavingExpensesOf_100_40_100_200() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 100 ) ) );
        friends.add( new Friend( "B", new Money( 40 ) ) );
        friends.add( new Friend( "C", new Money( 100 ) ) );
        friends.add( new Friend( "D", new Money( 200 ) ) );
        Money averageExpenditure = AverageCalculator.calculateAverage( friends );
        Transaction transaction = new Transaction( "","",new Money( 0 ) );
        Transaction actual = transaction.create( friends, friends.get( 0 ), averageExpenditure );
        Transaction expected = new Transaction( "A", "D", new Money( 10 ) );
        assertEquals( actual, expected );
    }
}

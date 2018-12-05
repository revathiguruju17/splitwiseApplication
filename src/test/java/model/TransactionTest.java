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
    void shouldReturnMoneyToBePaidByDebtorWhenCreditorHas150RsAndAverageIs100rs() {
        Money debtor = new Money( 20 );
        Money creditor = new Money( 150 );
        Money average = new Money( 100 );
        Money actual = Transaction.calculateTheMoneyToBeDebitedForCurrentTransaction( debtor, creditor, average );
        Money expected = new Money( 50 );
        assertEquals( actual, expected );
    }

    @Test
    void shouldReturnMoneyToBePaidByDebtorWhenCreditorHas220RsAndAverageIs100rs() {
        Money debtor = new Money( 20 );
        Money creditor = new Money( 220 );
        Money average = new Money( 100 );
        Money actual = Transaction.calculateTheMoneyToBeDebitedForCurrentTransaction( debtor, creditor, average );
        Money expected = new Money( 80 );
        assertEquals( actual, expected );
    }

    @Test
    void shouldReturnOneTransactionOfFriendsHavingExpensesOf_100_40_100_200(){
        List<Friend> friends = new ArrayList<>(  );
        friends.add( new Friend( "A",new Money( 100 ) ) );
        friends.add( new Friend( "B",new Money( 40 ) ) );
        friends.add( new Friend( "C",new Money( 100 ) ) );
        friends.add( new Friend( "D",new Money( 200 ) ) );
        Money averageExpenditure = Calculation.AverageCalculation( friends );
        Transaction actual = Transaction.createTransaction( friends,friends.get( 0 ), averageExpenditure);
        Transaction expected = new Transaction( "A","D",new Money( 10 ) );
        assertEquals( actual,expected );
    }
}

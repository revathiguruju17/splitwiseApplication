package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplitwiseApplicationTest {

    @Test
    void shouldReturnMoneyToBePaidByDebtorWhenCreditorHas150RsAndAverageIs100rs() {
        Money debtor = new Money( 20 );
        Money creditor = new Money( 150 );
        Money average = new Money( 100 );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        Money actual = splitwiseApplication.calculateTheMoneyToBeDebitedForCurrentTransaction( debtor, creditor, average );
        Money expected = new Money( 50 );
        assertEquals( actual, expected );
    }

    @Test
    void shouldReturnMoneyToBePaidByDebtorWhenCreditorHas220RsAndAverageIs100rs() {
        Money debtor = new Money( 20 );
        Money creditor = new Money( 220 );
        Money average = new Money( 100 );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        Money actual = splitwiseApplication.calculateTheMoneyToBeDebitedForCurrentTransaction( debtor, creditor, average );
        Money expected = new Money( 80 );
        assertEquals( actual, expected );
    }

    @Test
    void shouldReturnZeroTransactionsWhenAllFriendsHaveZeroExpenses() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 0 ) ) );
        friends.add( new Friend( "B", new Money( 0 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        List<Transaction> result = splitwiseApplication.settleTheExpenses( friends );
        assertTrue( result.isEmpty() );
    }

    @Test
    void shouldReturnZeroTransactionsWhenAllFriendsHaveEqualExpenses() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 100 ) ) );
        friends.add( new Friend( "B", new Money( 100 ) ) );
        friends.add( new Friend( "C", new Money( 100 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        List<Transaction> result = splitwiseApplication.settleTheExpenses( friends );
        assertTrue( result.isEmpty() );
    }

    @Test
    void shouldCalculateCorrectTransactionsForTheFriendsHavingExpenses100Rs_40Rs_100Rs_200Rs() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 100 ) ) );
        friends.add( new Friend( "B", new Money( 40 ) ) );
        friends.add( new Friend( "C", new Money( 100 ) ) );
        friends.add( new Friend( "D", new Money( 200 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        List<Transaction> result = splitwiseApplication.settleTheExpenses( friends );
        List<Transaction> expected = new ArrayList<>();
        expected.add( new Transaction( "A", "D", new Money( 10 ) ) );
        expected.add( new Transaction( "B", "D", new Money( 70 ) ) );
        expected.add( new Transaction( "C", "D", new Money( 10 ) ) );
        assertEquals( result, expected );
    }

    @Test
    void shouldCalculateCorrectTransactionsForTheFriendsHavingExpenses160Rs_90Rs_40Rs_30Rs() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 160 ) ) );
        friends.add( new Friend( "B", new Money( 90 ) ) );
        friends.add( new Friend( "C", new Money( 40 ) ) );
        friends.add( new Friend( "D", new Money( 30 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        List<Transaction> result = splitwiseApplication.settleTheExpenses( friends );
        List<Transaction> expected = new ArrayList<>();
        expected.add( new Transaction( "C", "A", new Money( 40 ) ) );
        expected.add( new Transaction( "D", "A", new Money( 40 ) ) );
        expected.add( new Transaction( "D", "B", new Money( 10 ) ) );
        assertEquals( result, expected );
    }

    @Test
    void shouldCalculateCorrectTransactionsForTheFriendsHavingExpenses163Rs_300Rs_200Rs() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 163 ) ) );
        friends.add( new Friend( "B", new Money( 300 ) ) );
        friends.add( new Friend( "C", new Money( 200 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        List<Transaction> result = splitwiseApplication.settleTheExpenses( friends );
        List<Transaction> expected = new ArrayList<>();
        expected.add( new Transaction( "A", "B", new Money( 58 ) ) );
        expected.add( new Transaction( "C", "B", new Money( 21 ) ) );
        assertEquals( result, expected );
    }
}

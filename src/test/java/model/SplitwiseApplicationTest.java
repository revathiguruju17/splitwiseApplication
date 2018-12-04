package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplitwiseApplicationTest {

    @Test
    void shouldReturnZeroAverageMoneyWhenEachFriendHavingZeroMoney() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 0 ) ) );
        friends.add( new Friend( "B", new Money( 0 ) ) );
        friends.add( new Friend( "C", new Money( 0 ) ) );
        friends.add( new Friend( "D", new Money( 0 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        Money actual = splitwiseApplication.calculateAverage( friends );
        Money expected = new Money( 0 );
        assertEquals( expected, actual );
    }

    @Test
    void shouldThrowExceptionWhenWeCalculateAverageForNegativeMoney() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 10 ) ) );
        friends.add( new Friend( "B", new Money( 20 ) ) );
        friends.add( new Friend( "C", new Money( -89 ) ) );
        friends.add( new Friend( "D", new Money( 50 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        assertThrows( IllegalArgumentException.class, () -> splitwiseApplication.calculateAverage( friends ) );
    }

    @Test
    void shouldCalculateCorrectAverageMoneyForFourFriendsHavingMoneyOf_100_40_100_200() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 100 ) ) );
        friends.add( new Friend( "B", new Money( 40 ) ) );
        friends.add( new Friend( "C", new Money( 100 ) ) );
        friends.add( new Friend( "D", new Money( 200 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        Money actual = splitwiseApplication.calculateAverage( friends );
        Money expected = new Money( 110 );
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnZeroTransactionsWhenAllFriendsHaveEqualExpenses(){
        List<Friend> friends = new ArrayList<>(  );
        friends.add( new Friend( "A", new Money( 100 ) ) );
        friends.add( new Friend( "B", new Money( 100 ) ) );
        friends.add( new Friend( "C", new Money( 100 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        List<Transaction> result = splitwiseApplication.calculateTransactions( friends );
        List<Transaction> expected = new ArrayList<>(  );
        assertEquals( expected,result );
    }

    @Test
    void shouldCalculateCorrectTransactionsForTheFriendsHavingExpenses100_40_100_200() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 100 ) ) );
        friends.add( new Friend( "B", new Money( 40 ) ) );
        friends.add( new Friend( "C", new Money( 100 ) ) );
        friends.add( new Friend( "D", new Money( 200 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        List<Transaction> result = splitwiseApplication.calculateTransactions( friends );
        List<Transaction> expected = new ArrayList<>();
        expected.add( new Transaction( "A", "D", new Money( 10 ) ) );
        expected.add( new Transaction( "B", "D", new Money( 70 ) ) );
        expected.add( new Transaction( "C", "D", new Money( 10 ) ) );
        assertEquals( result, expected );
    }

    @Test
    void shouldCalculateCorrectTransactionsForTheFriendsHavingExpenses160_90_40_30() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 160 ) ) );
        friends.add( new Friend( "B", new Money( 90 ) ) );
        friends.add( new Friend( "C", new Money( 40 ) ) );
        friends.add( new Friend( "D", new Money( 30 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        List<Transaction> result = splitwiseApplication.calculateTransactions( friends );
        List<Transaction> expected = new ArrayList<>();
        expected.add( new Transaction( "C", "A", new Money( 40 ) ) );
        expected.add( new Transaction( "D", "A", new Money( 40 ) ) );
        expected.add( new Transaction( "D", "B", new Money( 10 ) ) );
        assertEquals( result, expected );
    }

    @Test
    void shouldCalculateCorrectTransactionsForTheFriendsHavingExpenses163_300_200() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 163 ) ) );
        friends.add( new Friend( "B", new Money( 300 ) ) );
        friends.add( new Friend( "C", new Money( 200 ) ) );
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        List<Transaction> result = splitwiseApplication.calculateTransactions( friends );
        List<Transaction> expected = new ArrayList<>();
        expected.add( new Transaction( "A", "B", new Money( 58 ) ) );
        expected.add( new Transaction( "C", "B", new Money( 21 ) ) );
        assertEquals( result, expected );
    }
}

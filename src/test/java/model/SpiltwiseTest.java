package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpiltwiseTest {

    private List<Friend> friends;
    private Spiltwise spiltwise;

    @BeforeEach
    void setUp() {
        friends = new ArrayList<>();
        spiltwise = new Spiltwise();
    }

    @Test
    void shouldReturnZeroTransactionsWhenAllFriendsHaveZeroExpenses() {
        friends.add( new Friend( "A", new Money( 0 ) ) );
        friends.add( new Friend( "B", new Money( 0 ) ) );
        List<Transaction> result = spiltwise.settleTheExpenses( friends );
        assertTrue( result.isEmpty() );
    }

    @Test
    void shouldReturnZeroTransactionsWhenAllFriendsHaveEqualExpenses() {
        friends.add( new Friend( "A", new Money( 100 ) ) );
        friends.add( new Friend( "B", new Money( 100 ) ) );
        friends.add( new Friend( "C", new Money( 100 ) ) );
        List<Transaction> result = spiltwise.settleTheExpenses( friends );
        assertTrue( result.isEmpty() );
    }

    @Test
    void shouldReturnCorrectTransactionsForTheFriendsHavingExpensesOf100RsAnd200Rs() {
        friends.add( new Friend( "A", new Money( 100 ) ) );
        friends.add( new Friend( "B", new Money( 200 ) ) );
        List<Transaction> actual = spiltwise.settleTheExpenses( friends );
        assertEquals( actual.get( 0 ).getDebtor(),"A" );
        assertEquals( actual.get( 0 ).getCreditor(),"B" );
        assertEquals( actual.get( 0 ).getPayableAmount(),50 );
    }

    @Test
    void shouldCalculateCorrectTransactionsForTheFriendsHavingExpenses100Rs_40Rs_100Rs_200Rs() {
        friends.add( new Friend( "A", new Money( 100 ) ) );
        friends.add( new Friend( "B", new Money( 40 ) ) );
        friends.add( new Friend( "C", new Money( 100 ) ) );
        friends.add( new Friend( "D", new Money( 200 ) ) );
        List<Transaction> actual = spiltwise.settleTheExpenses( friends );
        assertEquals( actual.get( 0 ).getDebtor(),"A" );
        assertEquals( actual.get( 0 ).getCreditor(),"D" );
        assertEquals( actual.get( 0 ).getPayableAmount(),10 );
        assertEquals( actual.get( 1 ).getDebtor(),"B" );
        assertEquals( actual.get( 1 ).getCreditor(),"D" );
        assertEquals( actual.get( 1 ).getPayableAmount(),70 );
        assertEquals( actual.get( 2 ).getDebtor(),"C" );
        assertEquals( actual.get( 2 ).getCreditor(),"D" );
        assertEquals( actual.get( 2 ).getPayableAmount(),10 );
    }

    @Test
    void shouldCalculateCorrectTransactionsForTheFriendsHavingExpenses160Rs_90Rs_40Rs_30Rs() {
        friends.add( new Friend( "A", new Money( 160 ) ) );
        friends.add( new Friend( "B", new Money( 90 ) ) );
        friends.add( new Friend( "C", new Money( 40 ) ) );
        friends.add( new Friend( "D", new Money( 30 ) ) );
        List<Transaction> actual = spiltwise.settleTheExpenses( friends );
        assertEquals( actual.get( 0 ).getDebtor(),"C" );
        assertEquals( actual.get( 0 ).getCreditor(),"A" );
        assertEquals( actual.get( 0 ).getPayableAmount(),40 );
        assertEquals( actual.get( 1 ).getDebtor(),"D" );
        assertEquals( actual.get( 1 ).getCreditor(),"A" );
        assertEquals( actual.get( 1 ).getPayableAmount(),40 );
        assertEquals( actual.get( 2 ).getDebtor(),"D" );
        assertEquals( actual.get( 2 ).getCreditor(),"B" );
        assertEquals( actual.get( 2 ).getPayableAmount(),10 );
    }

    @Test
    void shouldCalculateCorrectTransactionsForTheFriendsHavingExpenses164Rs_300Rs_200Rs() {
        friends.add( new Friend( "A", new Money( 164 ) ) );
        friends.add( new Friend( "B", new Money( 300 ) ) );
        friends.add( new Friend( "C", new Money( 200 ) ) );
        List<Transaction> actual = spiltwise.settleTheExpenses( friends );
        assertEquals( actual.get( 0 ).getDebtor(),"A" );
        assertEquals( actual.get( 0 ).getCreditor(),"B" );
        assertEquals( actual.get( 0 ).getPayableAmount(),57 );
        assertEquals( actual.get( 1 ).getDebtor(),"C" );
        assertEquals( actual.get( 1 ).getCreditor(),"B" );
        assertEquals( actual.get( 1 ).getPayableAmount(),21 );
    }
}

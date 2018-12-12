package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void shouldReturnOneTransactionForTheFriendsHavingExpensesOf100_40_100_200() {
        List<Friend> friends = new ArrayList<>(  );
        friends.add( new Friend( "A", new Money( 100 ) ) );
        friends.add( new Friend( "B", new Money( 40 ) ) );
        friends.add( new Friend( "C", new Money( 100 ) ) );
        friends.add( new Friend( "D", new Money( 200 ) ) );
        Transaction transaction = new Transaction();
        transaction.create( friends,friends.get( 0 ),new Money( 110 ) );
        assertEquals( transaction.getDebtor(),"A" );
        assertEquals( transaction.getCreditor(),"D" );
        assertEquals( transaction.getPayableAmount(),10 );
    }
}

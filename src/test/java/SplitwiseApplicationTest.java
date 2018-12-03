import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitwiseApplicationTest {

    @Test
    void shouldReturn110ForAverageOf100_40_100_200() {
      Trip trip = new Trip();
      List<Friend> friends = trip.friendsInTheTrip();
      SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
      Money average = splitwiseApplication.calculateAverage( friends );
      Money result = new Money( 110 );
      assertEquals( result,average );
    }

    @Test
    void shouldReturnA_D10_B_D70_C_D10() {
        Trip trip = new Trip();
        List<Friend> friends = trip.friendsInTheTrip();
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        List<Transaction> transactions = splitwiseApplication.calculateTransactions( friends );
        String actual = transactions.get( 0 ).toString();
        String expected = "A->D, 10";
        assertEquals( actual,expected );
        String actual1 = transactions.get( 1 ).toString();
        String expected1 = "B->D, 70";
        assertEquals( actual1,expected1 );
        String actual2 = transactions.get( 2 ).toString();
        String expected2 = "C->D, 10";
        assertEquals( actual2,expected2 );
    }
}

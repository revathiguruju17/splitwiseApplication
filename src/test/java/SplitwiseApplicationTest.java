import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        List<Transaction> result = new ArrayList<>();
        result.add( new Transaction( "A", "D", new Money( 10 ) ) );
        result.add( new Transaction( "B", "D", new Money( 70 ) ) );
        result.add( new Transaction( "C", "D", new Money( 10 ) ) );
        assertEquals( result, transactions );
    }
}

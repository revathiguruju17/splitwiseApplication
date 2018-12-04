package model;

import controller.Trip;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TripTest {

    @Test
    void shouldReturnTrueIfFriendsListIsEmpty(){
        Trip trip = new Trip();
        List<Friend> friends = new ArrayList<>(  );
        boolean result = trip.isFriendsListEmpty( friends );
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfFriendsListIsNotEmpty(){
        Trip trip = new Trip();
        List<Friend> friends = new ArrayList<>(  );
        friends.add(new Friend( "A",new Money( 10 ) ));
        boolean result = trip.isFriendsListEmpty( friends );
        assertFalse(result);
    }
}

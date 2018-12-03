import java.util.ArrayList;
import java.util.List;

class Trip {
    private List<Friend> friends = new ArrayList<>();

    List<Friend> friendsInTheTrip() {
        Friend friend1 = new Friend( "A", new Money( 100 ) );
        Friend friend2 = new Friend( "B", new Money( 40 ) );
        Friend friend3 = new Friend( "C", new Money( 100 ) );
        Friend friend4 = new Friend( "D", new Money( 200 ) );
        friends.add( friend1 );
        friends.add( friend2 );
        friends.add( friend3 );
        friends.add( friend4 );
        return friends;
    }
}

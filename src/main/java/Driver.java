import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Trip trip = new Trip();
        List<Friend> friends =trip.friendsInTheTrip();
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        splitwiseApplication.calculateTransactions( friends );
    }
}

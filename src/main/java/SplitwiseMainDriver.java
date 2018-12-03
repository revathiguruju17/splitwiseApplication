import java.util.List;

public class SplitwiseMainDriver {
    public static void main(String[] args) {
        Trip trip = new Trip();
        List<Friend> friends =trip.friendsInTheTrip();
        SplitwiseApplication splitwiseApplication = new SplitwiseApplication();
        List<Transaction> transactions =splitwiseApplication.calculateTransactions( friends );
        for (Transaction transaction:transactions) {
            System.out.println(transaction.toString());
        }
    }
}

import java.util.ArrayList;
import java.util.List;

class SplitwiseApplication {
    List<Transaction> transactions = new ArrayList<>();

    List<Transaction> calculateTransactions(List<Friend> friends) {
        Money average = calculateAverage( friends );

        return null;
    }

    Money calculateAverage(List<Friend> friends) {
        Money totalExpense = new Money( 0 );
        Money average;
        for (Friend friend : friends) {
            Money money = friend.getExpense();
            totalExpense = totalExpense.add( money );
        }
        average = totalExpense.divide( new Money( friends.size() ) );
        return average;
    }
}

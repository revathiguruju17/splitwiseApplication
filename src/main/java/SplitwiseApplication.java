import java.util.ArrayList;
import java.util.List;

class SplitwiseApplication {
    private List<Transaction> transactions = new ArrayList<>();

    List<Transaction> calculateTransactions(List<Friend> friends) {
        Money average = calculateAverage( friends );
        for (Friend fromFriend : friends) {
            Money money = fromFriend.getExpense();
            boolean isSmaller = money.compare( average );
            if (isSmaller) {
                transactions.add( createTransaction( fromFriend, friends, average ) );
            }
        }
        return transactions;
    }

    private Transaction createTransaction(Friend fromFriend, List<Friend> friends, Money average) {
        Transaction transaction = new Transaction( "", "", new Money( 0 ) );
        for (Friend toFriend : friends) {
            Money money = toFriend.getExpense();
            boolean isGreater = average.compare( money );
            if (isGreater) {
                String fromPerson = fromFriend.getName();
                String toPerson = toFriend.getName();
                Money owedMoney = findOwedMoney( fromFriend.getExpense(), toFriend.getExpense(), average );
                transaction = new Transaction( fromPerson, toPerson, owedMoney );
                toFriend.setExpense( owedMoney );
            }
        }
        return transaction;
    }

    private Money findOwedMoney(Money from, Money to, Money average) {
        Money money = average.subtract( from );
        Money money1 = to.subtract( average );
        boolean isMoney1Lesser = money1.compare( money );
        if (isMoney1Lesser) {
            return to.subtract( from );
        }
        return average.subtract( from );
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

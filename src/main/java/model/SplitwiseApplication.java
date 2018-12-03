package model;

import java.util.ArrayList;
import java.util.List;

public class SplitwiseApplication {
    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> calculateTransactions(List<Friend> friends) {
        Money average = calculateAverage( friends );
        for (Friend fromFriend : friends) {
            Money money = fromFriend.getExpense();
            boolean isSmaller = money.isLesser( average );
            while (isSmaller) {
                createTransaction( friends, fromFriend, average );
                isSmaller = fromFriend.getExpense().isLesser( average );
            }
        }
        return transactions;
    }

    private void createTransaction(List<Friend> friends, Friend fromFriend, Money average) {
        for (Friend toFriend : friends) {
            Money money1 = toFriend.getExpense();
            boolean isGreater = money1.isGreater( average );
            if (isGreater) {
                String fromPerson = fromFriend.getName();
                String toPerson = toFriend.getName();
                Money owedMoney = findOwedMoney( fromFriend.getExpense(), toFriend.getExpense(), average );
                fromFriend.increaseExpense( owedMoney );
                toFriend.decreaseExpense( owedMoney );
                Transaction transaction = new Transaction( fromPerson, toPerson, owedMoney );
                transactions.add( transaction );
                break;
            }
        }
    }

    private Money findOwedMoney(Money from, Money to, Money average) {
        Money money = average.subtract( from );
        Money money1 = to.subtract( average );
        boolean isMoney1Lesser = money1.isLesser( money );
        if (isMoney1Lesser) {
            return to.subtract( average );
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

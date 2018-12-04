package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SplitwiseApplication {

    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SplitwiseApplication)) return false;
        SplitwiseApplication that = (SplitwiseApplication) o;
        return Objects.equals( transactions, that.transactions );
    }

    @Override
    public int hashCode() {
        return Objects.hash( transactions );
    }

    public List<Transaction> calculateTransactions(List<Friend> friends) {
        Money average = calculateAverage( friends );
        for (Friend fromFriend : friends) {
            Money money = fromFriend.getExpense();
            boolean isLesser = money.isLesser( average );
            while (isLesser) {
                transactions.add( createTransaction( friends, fromFriend, average ) );
                isLesser = fromFriend.getExpense().isLesser( average );
            }
        }
        return transactions;
    }

    Transaction createTransaction(List<Friend> friends, Friend fromWhom, Money average) {
        Transaction transaction = new Transaction( "", "", new Money( 0 ) );
        String fromPerson = fromWhom.getName();
        transaction.setFromFriend( fromPerson );
        for (Friend toWhom : friends) {
            Money money1 = toWhom.getExpense();
            boolean isGreater = money1.isGreater( average );
            if (isGreater) {
                String toPerson = toWhom.getName();
                Money owedMoney = findOwedMoney( fromWhom.getExpense(), toWhom.getExpense(), average );
                fromWhom.increaseExpense( owedMoney );
                toWhom.decreaseExpense( owedMoney );
                transaction.setToFriend( toPerson );
                transaction.setMoney( owedMoney );
                break;
            }
        }
        return transaction;
    }

    Money findOwedMoney(Money from, Money to, Money average) {
        Money owedMoney1 = average.subtract( from );
        Money owedMoney2 = to.subtract( average );
        boolean isOwedMoney1Greater = owedMoney1.isGreater( owedMoney2 );
        if (isOwedMoney1Greater) {
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

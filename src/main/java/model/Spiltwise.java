package model;

import java.util.ArrayList;
import java.util.List;

public class Spiltwise {

    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> settleTheExpenses(List<Friend> friends) {
        Money averageExpenditure = calculateAverageOfAllTheExpenses( friends );
        for (Friend debtor : friends) {
            Money debtorExpense = debtor.getExpense();
            boolean isLesser = debtorExpense.isLesser( averageExpenditure );
            while (isLesser) {
                Transaction transaction = new Transaction(  );
                transactions.add( transaction.create( friends, debtor, averageExpenditure ) );
                isLesser = debtor.getExpense().isLesser( averageExpenditure );
            }
        }
        return transactions;
    }

    private Money calculateAverageOfAllTheExpenses(List<Friend> friends)  {
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



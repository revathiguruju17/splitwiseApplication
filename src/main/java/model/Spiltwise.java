package model;

import java.util.ArrayList;
import java.util.List;

public class Spiltwise {

    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> settleTheExpenses(List<Friend> friends) {
        Money averageExpenditure = AverageCalculator.calculateAverage( friends );
        for (Friend debtor : friends) {
            Money money = debtor.getExpense();
            boolean isLesser = money.isLesser( averageExpenditure );
            while (isLesser) {
                Transaction transaction = new Transaction( "", "", new Money( 0 ) );
                transactions.add( transaction.createTransaction( friends, debtor, averageExpenditure ) );
                isLesser = debtor.getExpense().isLesser( averageExpenditure );
            }
        }
        return transactions;
    }
}

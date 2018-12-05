package model;

import java.util.ArrayList;
import java.util.List;

public class SplitwiseApplication {

    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> settleTheExpenses(List<Friend> friends) {
        Money averageExpenditure = Calculation.AverageCalculation( friends );
        for (Friend debtor : friends) {
            Money money = debtor.getExpense();
            boolean isLesser = money.isLesser( averageExpenditure );
            while (isLesser) {
                transactions.add( Transaction.createTransaction( friends, debtor, averageExpenditure ) );
                isLesser = debtor.getExpense().isLesser( averageExpenditure );
            }
        }
        return transactions;
    }
}

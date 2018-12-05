package model;

import java.util.ArrayList;
import java.util.List;

public class SplitwiseApplication {

    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> calculateTransactions(List<Friend> friends) {
        Money averageExpenditure = calculateAverageExpenditure( friends );
        for (Friend debtor : friends) {
            Money money = debtor.getExpense();
            boolean isLesser = money.isLesser( averageExpenditure );
            while (isLesser) {
                transactions.add( createTransaction( friends, debtor, averageExpenditure ) );
                isLesser = debtor.getExpense().isLesser( averageExpenditure );
            }
        }
        return transactions;
    }

    Transaction createTransaction(List<Friend> friends, Friend debtor, Money average) {
        Transaction transaction = new Transaction( "", "", new Money( 0 ) );
        String debtorName = debtor.getName();
        transaction.setDebtor( debtorName );
        for (Friend creditor : friends) {
            Money creditorExpense = creditor.getExpense();
            boolean isGreater = creditorExpense.isGreater( average );
            if (isGreater) {
                String creditorName = creditor.getName();
                Money debitableAmountForCurrentTransaction = calculateTheMoneyToBeDebitedForCurrentTransaction( debtor.getExpense(), creditor.getExpense(), average );
                debtor.increaseExpense( debitableAmountForCurrentTransaction );
                creditor.decreaseExpense( debitableAmountForCurrentTransaction );
                transaction.setCreditor( creditorName );
                transaction.setPayableAmount( debitableAmountForCurrentTransaction );
                break;
            }
        }
        return transaction;
    }

    Money calculateTheMoneyToBeDebitedForCurrentTransaction(Money expenseOfSender, Money expenseOfReceiver, Money average) {
        Money totalDebitableAmount = average.subtract( expenseOfSender );
        Money totalCreditableAmount = expenseOfReceiver.subtract( average );
        if (totalDebitableAmount.isGreater( totalCreditableAmount )) {
            return totalCreditableAmount;
        }
        return totalDebitableAmount;
    }

    Money calculateAverageExpenditure(List<Friend> friends) {
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

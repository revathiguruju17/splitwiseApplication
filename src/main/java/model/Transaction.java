package model;

import java.util.List;

public class Transaction {
    private String debtor;
    private String creditor;
    private Money payableAmount;

    Transaction() {
        this.debtor = "";
        this.creditor = "";
        this.payableAmount = new Money( 0 );
    }

    private void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    private void setCreditor(String toFriend) {
        this.creditor = toFriend;
    }

    private void setPayableAmount(Money payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getDebtor() {
        return debtor;
    }

    public String getCreditor() {
        return creditor;
    }

    public int getPayableAmount() {
        return payableAmount.getValue();
    }

    Transaction create(List<Friend> friends, Friend debtor, Money average) {
        this.setDebtor( debtor.getName() );
        for (Friend creditor : friends) {
            Money creditorExpense = creditor.getExpense();
            boolean isGreater = creditorExpense.isGreater( average );
            if (isGreater) {
                Money debitableAmountForCurrentTransaction = calculateTheMoneyToBeDebitedForCurrentTransaction
                        ( debtor.getExpense(), creditor.getExpense(), average );
                debtor.increaseExpense( debitableAmountForCurrentTransaction );
                creditor.decreaseExpense( debitableAmountForCurrentTransaction );
                this.setCreditor( creditor.getName() );
                this.setPayableAmount( debitableAmountForCurrentTransaction );
                break;
            }
        }
        return this;
    }

    private Money calculateTheMoneyToBeDebitedForCurrentTransaction
            (Money expenseOfSender, Money expenseOfReceiver, Money average) {
        Money totalDebitableAmount = average.subtract( expenseOfSender );
        Money totalCreditableAmount = expenseOfReceiver.subtract( average );
        if (totalDebitableAmount.isGreater( totalCreditableAmount )) {
            return totalCreditableAmount;
        }
        return totalDebitableAmount;
    }
}

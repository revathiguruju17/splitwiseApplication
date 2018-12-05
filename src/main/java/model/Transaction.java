package model;

import java.util.List;
import java.util.Objects;

public class Transaction {
    private String debtor;
    private String creditor;
    private Money payableAmount;

    Transaction(String debtor, String creditor, Money payableAmount) {
        this.debtor = debtor;
        this.creditor = creditor;
        this.payableAmount = payableAmount;
    }

    @Override
    public String toString() {
        return debtor + "->" + creditor + ", " + payableAmount.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals( debtor, that.debtor ) &&
                Objects.equals( creditor, that.creditor ) &&
                Objects.equals( payableAmount, that.payableAmount );
    }

    @Override
    public int hashCode() {
        return Objects.hash( debtor, creditor, payableAmount );
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

    static Transaction createTransaction(List<Friend> friends, Friend debtor, Money average) {
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

    static Money calculateTheMoneyToBeDebitedForCurrentTransaction(Money expenseOfSender, Money expenseOfReceiver, Money average) {
        Money totalDebitableAmount = average.subtract( expenseOfSender );
        Money totalCreditableAmount = expenseOfReceiver.subtract( average );
        if (totalDebitableAmount.isGreater( totalCreditableAmount )) {
            return totalCreditableAmount;
        }
        return totalDebitableAmount;
    }
}

package model;

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

    void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    void setCreditor(String toFriend) {
        this.creditor = toFriend;
    }

    void setPayableAmount(Money payableAmount) {
        this.payableAmount = payableAmount;
    }
}

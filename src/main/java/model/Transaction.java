package model;

import java.util.Objects;

public class Transaction {
    private String fromFriend;
    private String toFriend;
    private Money money;

    Transaction(String fromFriend, String toFriend, Money money) {
        this.fromFriend = fromFriend;
        this.toFriend = toFriend;
        this.money = money;
    }

    @Override
    public String toString() {
        return fromFriend + "->" + toFriend + ", " + money.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals( fromFriend, that.fromFriend ) &&
                Objects.equals( toFriend, that.toFriend ) &&
                Objects.equals( money, that.money );
    }

    @Override
    public int hashCode() {
        return Objects.hash( fromFriend, toFriend, money );
    }

    void setFromFriend(String fromFriend) {
        this.fromFriend = fromFriend;
    }

    void setToFriend(String toFriend) {
        this.toFriend = toFriend;
    }

    void setMoney(Money money) {
        this.money = money;
    }
}

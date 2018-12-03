import java.util.List;

class Transaction {
    private String fromFriend;
    private String toFriend;
    private Money money;

    Transaction(String fromFriend, String toFriend, Money money) {
        this.fromFriend = fromFriend;
        this.toFriend = toFriend;
        this.money=money;
    }

    @Override
    public String toString() {
        return fromFriend+"->"+toFriend+", "+money.toString();
    }
}

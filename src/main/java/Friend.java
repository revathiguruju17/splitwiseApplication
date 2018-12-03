public class Friend {
    private String name;
    private Money expense;

    Friend(String name, Money expense) {
        this.name = name;
        this.expense = expense;
    }

    public Money getExpense() {
        return expense;
    }
}

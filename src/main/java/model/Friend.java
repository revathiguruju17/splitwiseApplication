package model;

public class Friend {
    private String name;
    private Money expense;

    public Friend(String name, Money expense) {
        this.name = name;
        this.expense = expense;
    }

    Money getExpense() {
        return expense;
    }

    String getName() {
        return name;
    }

    void decreaseExpense(Money owedMoney) {
        expense = expense.subtract( owedMoney );
    }

    void increaseExpense(Money owedMoney) {
        expense = expense.add( owedMoney );
    }

    @Override
    public String toString() {
        return name + " " + expense.toString();
    }
}

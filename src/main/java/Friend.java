class Friend {
    private String name;
    private Money expense;

    Friend(String name, Money expense) {
        this.name = name;
        this.expense = expense;
    }

    Money getExpense() {
        return expense;
    }

    String getName() { return name; }

    public void setExpense(Money owedMoney) {
        expense = expense.subtract( owedMoney );
    }
}

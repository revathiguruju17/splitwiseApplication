package model;

public class Money {

    private int value;

    public Money(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    Money add(Money money) {
        Money result = new Money( 0 );
        result.value = value + money.value;
        return result;
    }

    Money subtract(Money money) {
        Money result = new Money( 0 );
        result.value = value - money.value;
        return result;
    }

    Money divide(Money money) {
        double result;
        result = (float) value / money.value;
        return new Money( (int) Math.round( result ) );
    }

    boolean isLesser(Money money) {
        return value < money.value;
    }

    boolean isGreater(Money money) {
        return value > money.value;
    }
}

package model;

import java.util.Objects;

public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
        checkForNegativeNumbers();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) return false;
        Money money = (Money) obj;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash( value );
    }

    @Override
    public String toString() {
        return Double.toString( value );
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
        result= (float)value / money.value;
        return new Money( (int)Math.round( result ) );
    }

    private void checkForNegativeNumbers() {
        if (value < 0) {
            throw new IllegalArgumentException( "Money should not be negative. Enter valid money" );
        }
    }

    boolean isLesser(Money money) {
        return value < money.value;
    }

    boolean isGreater(Money money) {
        return value > money.value;
    }
}

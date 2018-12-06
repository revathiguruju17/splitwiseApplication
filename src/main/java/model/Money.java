package model;

import java.util.Objects;

public class Money {
    private double value;

    public Money(double value) {
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
        return new Money( this.value + money.value );
    }

    Money subtract(Money money) {
        return new Money( value - money.value );
    }

    Money divide(Money money) {
        Money result = new Money( value / money.value );
        result.value = Math.round( result.value * 100.0 ) / 100.0;
        return result;
    }

    private void checkForNegativeNumbers()  {
        if (value < 0) {
            throw new IllegalArgumentException( "model.Money should not be negative. Enter valid money" );
        }
    }

    boolean isLesser(Money money) {
        return value < money.value;
    }

    boolean isGreater(Money money) {
        return value > money.value;
    }
}

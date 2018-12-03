import java.util.Objects;

public class Money {
    private int value;

    Money(int value) {
        this.value = value;
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

    Money add(Money money) throws IllegalArgumentException {
        this.checkForNegativeNumbers();
        money.checkForNegativeNumbers();
        return new Money( value + money.value );
    }

    Money subtract(Money money) throws IllegalArgumentException {
        this.checkForNegativeNumbers();
        money.checkForNegativeNumbers();
        return new Money( value - money.value );
    }

    Money divide(Money money) throws IllegalArgumentException {
        this.checkForNegativeNumbers();
        money.checkForNegativeNumbers();
        return new Money( value / money.value );
    }

    void checkForNegativeNumbers() throws IllegalArgumentException {
        if(value<1){
            throw new IllegalArgumentException( "Money should not be negative. Enter valid money" );
        }
    }

    @Override
    public String toString() {
        return Integer.toString( value );
    }
}

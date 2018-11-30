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

    Money add(Money money) {
        return new Money( this.value + money.value );
    }
}

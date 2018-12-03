import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void shouldReturnTrueForTwoValidMoneyObjectsWithSameValues() {
        Money money = new Money( 100 );
        Money money1 = new Money( 100 );
        assertEquals( money, money1 );
    }

    @Test
    void shouldReturnFalseForTwoMoneyObjectsWithDifferentValues() {
        Money money = new Money( 20 );
        Money money1 = new Money( 78 );
        assertNotEquals( money, money1 );
    }

    @Test
    void shouldReturnFalseForTwoDifferentObjects() {
        Money money = new Money( 100 );
        assertNotEquals( money, 12 );
    }

    @Test
    void shouldReturn90_for40plus50() throws NegativeMoneyException {
        Money money = new Money( 40 );
        Money money1 = new Money( 50 );
        Money result = new Money( 90 );
        assertEquals( money.add( money1 ), result );
    }

    @Test
    void shouldReturn18_for50minus32() throws NegativeMoneyException {
        Money money = new Money( 50 );
        Money money1 = new Money( 32 );
        Money result = new Money( 18 );
        assertEquals( money.subtract( money1 ), result );
    }

    @Test
    void should24_for72DividedBy3() throws NegativeMoneyException {
        Money money = new Money( 72 );
        Money money1 = new Money( 3 );
        Money result = new Money( 24 );
        assertEquals( money.divide( money1 ), result );
    }

    @Test
    void shouldThrowExceptionForNegativeValues() {
        Money money = new Money( -90 );
        assertThrows( NegativeMoneyException.class, money::checkForNegativeNumbers );
    }

    @Test
    void shouldThrowExceptionForAddingNegativeValue() {
        Money money = new Money( -10 );
        Money money1 = new Money( 90 );
        assertThrows( NegativeMoneyException.class, () -> money.add( money1 ) );
    }
}

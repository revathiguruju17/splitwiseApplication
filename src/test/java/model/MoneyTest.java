package model;

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
    void shouldThrowAnExceptionForNegativeValues(){
        assertThrows( IllegalArgumentException.class, ()-> new Money( -9 ));
    }

    @Test
    void shouldReturn90_for40plus50() {
        Money money = new Money( 40 );
        Money money1 = new Money( 50 );
        Money result = new Money( 90 );
        assertEquals( money.add( money1 ), result );
    }

    @Test
    void shouldReturn18_for50minus32()  {
        Money money = new Money( 50 );
        Money money1 = new Money( 32 );
        Money result = new Money( 18 );
        assertEquals( money.subtract( money1 ), result );
    }

    @Test
    void should24_for72DividedBy3()  {
        Money money = new Money( 72 );
        Money money1 = new Money( 3 );
        Money result = new Money( 24 );
        assertEquals( money.divide( money1 ), result );
    }

    @Test
    void shouldReturnStringForGivenMoneyObject(){
        Money money = new Money( 10 );
        String result = "10.0";
        assertEquals( result, money.toString() );
    }

    @Test
    void shouldReturnTrueIf_10_LesserThan30(){
        Money money = new Money( 10 );
        Money money1 = new Money( 30 );
        boolean isLesser = money.isLesser( money1 );
        assertTrue(isLesser);
    }

    @Test
    void shouldReturnFalseIf_58_GreaterThan_30(){
        Money money = new Money( 58 );
        Money money1 = new Money( 30 );
        boolean isLesser = money.isLesser( money1);
        assertFalse(isLesser);
    }

    @Test
    void shouldReturnTrueIf_10_GreaterThan3(){
        Money money = new Money( 10 );
        Money money1 = new Money( 3 );
        boolean isGreater = money.isGreater( money1 );
        assertTrue(isGreater);
    }

    @Test
    void shouldReturnFalseIf_158_GreaterThan_298(){
        Money money = new Money( 158 );
        Money money1 = new Money( 298 );
        boolean isGreater = money.isGreater( money1);
        assertFalse(isGreater);
    }

}

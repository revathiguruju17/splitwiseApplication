package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void shouldReturn90_for40plus50() {
        Money money = new Money( 40 );
        Money money1 = new Money( 50 );
        assertEquals( money.add( money1 ).getValue(), 90 );
    }

    @Test
    void shouldReturn18_for50minus32()  {
        Money money = new Money( 50 );
        Money money1 = new Money( 32 );
        assertEquals( money.subtract( money1 ).getValue(), 18 );
    }

    @Test
    void should24_for72DividedBy3()  {
        Money money = new Money( 72 );
        Money money1 = new Money( 3 );
        assertEquals(money.divide( money1 ).getValue(), 24 );
    }

    @Test
    void shouldReturnTrueIf_10_LesserThan30(){
        Money money = new Money( 10 );
        Money money1 = new Money( 30 );
        assertTrue(money.isLesser( money1 ));
    }

    @Test
    void shouldReturnFalseIf_58_GreaterThan_30(){
        Money money = new Money( 58 );
        Money money1 = new Money( 30 );
        assertFalse(money.isLesser( money1));
    }

    @Test
    void shouldReturnTrueIf_10_GreaterThan3(){
        Money money = new Money( 10 );
        Money money1 = new Money( 3 );
        assertTrue(money.isGreater( money1 ));
    }

    @Test
    void shouldReturnFalseIf_158_GreaterThan_298(){
        Money money = new Money( 158 );
        Money money1 = new Money( 298 );
        assertFalse(money.isGreater( money1));
    }

    @Test
    void shouldRoundOffTheQuotientToTheNearestValueForDivisionOf_7_And_4(){
        Money money = new Money( 7 );
        Money money1 = new Money( 4 );
        assertEquals(money.divide( money1 ).getValue(),2);
    }

    @Test
    void shouldRoundOffTheQuotientToTheNearestValueForDivisionOf_5_And_4(){
        Money money = new Money( 5 );
        Money money1 = new Money( 4 );
        assertEquals(money.divide( money1 ).getValue(),1);
    }
}

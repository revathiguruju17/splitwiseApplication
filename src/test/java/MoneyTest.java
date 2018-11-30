import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @DisplayName("should return true for two valid money having same value")
    @Test
    void expectingTrueForSameMoney() {
        Money money = new Money( 100 );
        Money money1 = new Money( 100 );
        assertEquals( money, money1 );
    }

    @DisplayName("should return false for two valid money having different values")
    @Test
    void expectingFalseForDifferentPersons() {
        Money money = new Money( 20 );
        Money money1 = new Money( 78 );
        assertNotEquals( money, money1 );
    }

    @DisplayName("should return false for different objects")
    @Test
    void expectingFalseForInvalidObject() {
        Money money = new Money( 100 );
        assertNotEquals( money, 12 );
    }

    @DisplayName( "should return money of 90rs for 40rs and 50rs" )
    @Test
    void expecting90_for40plus50(){
        Money money = new Money( 40 );
        Money money1 = new Money( 50 );
        Money result = new Money( 90 );
        assertEquals( money.add( money1 ),result );
    }
}

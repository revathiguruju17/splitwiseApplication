package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationTest {
    @Test
    void shouldReturnZeroAsAverageMoneyWhenEachFriendHavingAnExpenseZero() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 0 ) ) );
        friends.add( new Friend( "B", new Money( 0 ) ) );
        friends.add( new Friend( "C", new Money( 0 ) ) );
        Money actual = Calculation.AverageCalculation( friends );
        Money expected = new Money( 0 );
        assertEquals( expected, actual );
    }

    @Test
    void shouldThrowExceptionWhenWeCalculateAverageForNegativeMoney() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 10 ) ) );
        friends.add( new Friend( "B", new Money( 20 ) ) );
        friends.add( new Friend( "C", new Money( -89 ) ) );
        friends.add( new Friend( "D", new Money( 50 ) ) );
        assertThrows( IllegalArgumentException.class, () -> Calculation.AverageCalculation( friends ) );
    }

    @Test
    void shouldCalculateCorrectAverageMoneyForFourFriendsHavingMoneyOf_100Rs_40Rs_100Rs_200Rs() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 100 ) ) );
        friends.add( new Friend( "B", new Money( 40 ) ) );
        friends.add( new Friend( "C", new Money( 100 ) ) );
        friends.add( new Friend( "D", new Money( 200 ) ) );
        Money actual = Calculation.AverageCalculation( friends );
        Money expected = new Money( 110 );
        assertEquals( expected, actual );
    }

    @Test
    void shouldCalculateAverageMoneyWhichIsRoundedOffToTwoDecimalPointsForFriendsHavingMoneyOf_101Rs_158Rs_69Rs() {
        List<Friend> friends = new ArrayList<>();
        friends.add( new Friend( "A", new Money( 101 ) ) );
        friends.add( new Friend( "B", new Money( 158 ) ) );
        friends.add( new Friend( "C", new Money( 69 ) ) );
        Money actual = Calculation.AverageCalculation( friends );
        Money expected = new Money( 109.33 );
        assertEquals( expected, actual );
    }

}

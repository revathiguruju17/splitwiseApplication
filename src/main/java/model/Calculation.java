package model;

import java.util.List;

class Calculation {
    static Money AverageCalculation(List<Friend> friends) {
        Money totalExpense = new Money( 0 );
        Money average;
        for (Friend friend : friends) {
            Money money = friend.getExpense();
            totalExpense = totalExpense.add( money );
        }
        average = totalExpense.divide( new Money( friends.size() ) );
        return average;
    }
}

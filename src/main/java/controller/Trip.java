package controller;

import model.Friend;
import model.Money;
import model.Spiltwise;
import model.Transaction;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

class Trip {
    private List<Friend> friends = new ArrayList<>();

    void friendsInTheTrip() {
        addFriendsToTheTrip();
        if (isFriendsListEmpty( friends )) {
            throw new IllegalArgumentException( "the friends list is empty" );
        }
        Spiltwise spiltwise = new Spiltwise();
        List<Transaction> transactions = spiltwise.settleTheExpenses( friends );
        displayTheTransactions( transactions );
    }

    private void addFriendsToTheTrip() {
        OutputDriver.printMessage( "enter the number of friends in the trip" );
        int numberOfFriends = InputDriver.readInputAsInt();
        OutputDriver.printMessage( "enter the list of friends and their expenses" );
        for (int i = 0; i < numberOfFriends; i++) {
            String name = InputDriver.readInputAsString();
            double moneySpent = InputDriver.readInputAsDouble();
            friends.add( new Friend( name, new Money( moneySpent ) ) );
        }
    }

    private void displayTheTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            OutputDriver.printMessage( transaction.toString() );
        }
    }

    boolean isFriendsListEmpty(List<Friend> friends) {
        return friends.isEmpty();
    }
}

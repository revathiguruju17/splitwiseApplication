package controller;

import model.Friend;
import model.Money;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

class Trip {
    private List<Friend> friends = new ArrayList<>();

    List<Friend> friendsInTheTrip() {
        OutputDriver.printMessage( "enter the number of friends in the trip" );
        int numberOfFriends = InputDriver.readInputAsInt();
        OutputDriver.printMessage( "enter the list of friends and their expenses" );
        for (int i = 0; i < numberOfFriends; i++) {
            String name = InputDriver.readInputAsString();
            int moneySpent = InputDriver.readInputAsInt();
            friends.add( new Friend( name, new Money( moneySpent ) ) );
        }
        return friends;
    }
}

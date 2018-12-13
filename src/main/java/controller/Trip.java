package controller;

import model.Friend;
import model.InputValidator;
import model.Money;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

class Trip {
    private List<Friend> friends = new ArrayList<>();

    List<Friend> getFriends() {
        OutputDriver.printMessage( "enter the number of friends in the trip" );
        String numberOfFriends = InputDriver.readInput();
        int validNumberOfFriends = getValidInteger( numberOfFriends );
        OutputDriver.printMessage( "enter the name and expense of all the friends" );
        for (int i = 0; i < validNumberOfFriends; i++) {
            String name = InputDriver.readInput();
            String validName = getValidString( name );
            String expense = InputDriver.readInput();
            int validExpense = getValidInteger( expense );
            friends.add( new Friend( validName, new Money( validExpense ) ) );
        }
        return friends;
    }

    private int getValidInteger(String value) {
        while (InputValidator.isValidString( value )) {
            value = askAgainForValue();
        }
        return Integer.parseInt( value );
    }

    private String getValidString(String string) {
        while (InputValidator.isValidInteger( string )) {
            string = askAgainForName();
        }
        return string;
    }

    private String askAgainForName() {
        OutputDriver.printMessage( "Please enter a valid name" );
        return InputDriver.readInput();
    }

    private String askAgainForValue() {
        OutputDriver.printMessage( "Please enter a valid number" );
        return InputDriver.readInput();
    }
}

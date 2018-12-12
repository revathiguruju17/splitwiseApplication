package controller;

import model.Friend;
import model.Money;
import view.InputDriver;
import view.OutputDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Trip {
    private List<Friend> friends = new ArrayList<>();

    List<Friend> getFriends() {
        OutputDriver.printMessage( "enter the number of friends in the trip" );
        int numberOfFriends = getValidInteger();
        OutputDriver.printMessage( "enter the name and expense of all the friends" );
        for (int i = 0; i < numberOfFriends; i++) {
            String name = getValidString();
            int expense = getValidInteger();
            friends.add( new Friend( name, new Money( expense ) ) );
        }
        return friends;
    }

    private int getValidInteger() {
        String value = InputDriver.readInput();
        while (isString( value )) {
            value = askAgainForValue();
        }
        return Integer.parseInt( value );
    }

    private boolean isString(String string) {
        Pattern pattern = Pattern.compile( ".*[^0-9].*" );
        return pattern.matcher( string ).matches();
    }

    private String askAgainForValue() {
        OutputDriver.printMessage( "Please enter a valid number" );
        return InputDriver.readInput();
    }

    private String getValidString() {
        String name = InputDriver.readInput();
        while (isInteger( name )) {
            name = askAgainForName();
        }
        return name;
    }

    private boolean isInteger(String string) {
        Pattern pattern = Pattern.compile( ".*[^a-z][^A-Z].*" );
        return pattern.matcher( string ).matches();
    }

    private String askAgainForName() {
        OutputDriver.printMessage( "Please enter a valid name" );
        return InputDriver.readInput();
    }
}

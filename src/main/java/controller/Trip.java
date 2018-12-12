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
        String value = "";
        boolean isString = true;
        Pattern pattern = Pattern.compile( ".*[^0-9].*" );
        while (isString) {
            value = InputDriver.readInput();
            isString = pattern.matcher( value ).matches();
            if (isString) {
                OutputDriver.printMessage( "please enter valid number" );
            }
        }
        return Integer.parseInt( value );
    }

    private String getValidString() {
        String name = "";
        boolean isNumeric = true;
        Pattern pattern = Pattern.compile( ".*[^a-z][^A-Z].*" );
        while (isNumeric) {
            name = InputDriver.readInput();
            isNumeric = pattern.matcher( name ).matches();
            if (isNumeric) {
                OutputDriver.printMessage( "please enter a valid name" );
            }
        }
        return name;
    }

}

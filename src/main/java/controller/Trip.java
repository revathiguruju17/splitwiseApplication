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
        int numberOfFriends = getNumberOfFriends();
        OutputDriver.printMessage( "enter the name and expense of all the friends" );
        for (int i = 0; i < numberOfFriends; i++) {
            String name = getFriendName();
            int expense = getExpense();
            friends.add( new Friend( name, new Money( expense ) ) );
        }
        return friends;
    }

    private int getNumberOfFriends() {
        return Integer.parseInt( InputDriver.readInput() );
    }

    private int getExpense() {
        String expense ="";
        boolean numeric = true;
        Pattern pattern = Pattern.compile( ".*[^0-9].*" );
        while (numeric){
            expense = InputDriver.readInput();
            numeric = pattern.matcher( expense ).matches();
            if(numeric){
                System.out.println("please enter valid amount");
            }
        }
        return Integer.parseInt( expense );
    }

    private String getFriendName() {
        String name = "";
        boolean numeric = true;
        Pattern pattern = Pattern.compile( ".*[^a-z][^A-Z].*" );
        while (numeric) {
            name = InputDriver.readInput();
            numeric = pattern.matcher( name ).matches();
            if (numeric) {
                System.out.println( "please enter a valid name" );
            }
        }
        return name;
    }

}

package model;

import java.util.regex.Pattern;

public class InputValidator {

    public static  boolean isValidInteger(String string) {
        Pattern pattern = Pattern.compile( ".*[^a-z][^A-Z].*" );
        return pattern.matcher( string ).matches();
    }

    public static boolean isValidString(String string) {
        Pattern pattern = Pattern.compile( ".*[^0-9].*" );
        return pattern.matcher( string ).matches();
    }

}

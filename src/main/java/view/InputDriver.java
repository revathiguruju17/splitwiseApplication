package view;


import java.util.Scanner;

public class InputDriver {
    private static Scanner scanner = new Scanner( System.in );

    public static int readInputAsInt(){
        return scanner.nextInt();
    }

    public static String readInputAsString(){
        return scanner.next();
    }
}
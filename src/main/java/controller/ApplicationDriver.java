package controller;

import model.Friend;
import model.Spiltwise;
import model.Transaction;
import view.OutputDriver;

import java.util.List;

public class ApplicationDriver {
    public static void main(String[] args) {
        Trip trip = new Trip();
        List<Friend> friends = trip.getFriends();
        Spiltwise spiltwise = new Spiltwise();
        List<Transaction> transactions = spiltwise.settleTheExpenses( friends );
        displayTheTransactions( transactions );
    }

    private static void displayTheTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            String debtor = transaction.getDebtor();
            String creditor = transaction.getCreditor();
            int payableAmount = transaction.getPayableAmount();
            OutputDriver.printMessage( debtor + " -> " + creditor + " , " + payableAmount );
        }
    }

}

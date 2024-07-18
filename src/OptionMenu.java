import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap; //the HashMap class
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    // Store a couple of recalls of account numbers to a mapping,
    // the map is named 'data' 
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(123, 123); //customer's number and PIN pair
                data.put(321, 321);

                System.err.println("Welcome to hte ATM Porject!");
                System.err.println("Enter your customer number");
                setCustomerNumber(menuInput.nextInt());

                System.err.println("Enter your PIN Number: ");
                setPIN(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s). Only Integers are allowed." + "\n");
                x = 2;
            }

            int cn = getCustomerNumber();
            int pn = getPIN();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else {
                System.out.println("\n" + "Wrong Customer Number and/or PIN combination." + "\n");
            } 
        } while (x == 1);
    }


    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println(" Type '1' - Checking Account");
        System.out.println(" Type '2' - Savings Account ");
        System.out.println(" Type '3' - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> getChecking();
            case 2 -> getSavings();
            case 3 -> System.out.println("Thank you for using our ATM. Have a good day");
            default -> System.out.println("Invalid. Exiting...");
        }

    }

    public void getChecking() {
        System.out.println("Checking Account Options: ");
        System.out.println(" Type '1' - View Balance");
        System.out.println(" Type '2' - Withdraw Funds");
        System.out.println(" Type '3' - Deposit Funds");
        System.out.println(" Type '4' - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
            }
            case 2 -> {
                getCheckingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getCheckingDepositInput();
                getAccountType();
            }
            case 4 -> {
                System.out.println("Thank you for using our ATM. Have a good day");
            }
            default -> System.out.println("Invalid. Exiting...");
        }

    }

    public void getSavings() {
        System.out.println("Savings Account Options: ");
        System.out.println(" Type '1' - View Balance");
        System.out.println(" Type '2' - Withdraw Funds");
        System.out.println(" Type '3' - Deposit Funds");
        System.out.println(" Type '4' - Exit");

    int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Savings Account Balance: " + moneyFormat.format(getSavingsBalance()));
                getAccountType();
            }
            case 2 -> {
                getSavingsWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getSavingsDepositInput();
                getAccountType();
            }
            case 4 -> {
                System.out.println("Thank you for using our ATM. Have a good day");
            }
            default -> System.out.println("invalid. Exiting...");
        }

    }

}
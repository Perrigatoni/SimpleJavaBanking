import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    
    private int customerNumber;
    private int PIN;
    private double checkingBalance = 0;
    private double savingsBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    // Setters and Getters
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPIN(int PIN) {
        this.PIN = PIN;
        return PIN;
    }

    public int getPIN() {
        return this.PIN;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
    // Withdrawing
    public double calcCheckingWithdraw(double amount) {
        checkingBalance -= amount;
        return checkingBalance;
    }

    public double calcSavingsWithdraw(double amount) {
        savingsBalance -= amount;
        return savingsBalance;
    }
    // Depositing
    public double calcCheckingDeposit(double amount) {
        checkingBalance += amount;
        return checkingBalance;
    }

    public double calcSavingsDeposit(double amount) {
        savingsBalance += amount;
        return savingsBalance;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Insufficient Balance. Cannot execute transaction!" + "\n");
        }
    }

    public void getSavingsWithdrawInput() {
        System.out.println("Savings Account balance: " + moneyFormat.format(savingsBalance));
        System.out.println("Amount to withdraw from Savings Account: ");
        double amount = input.nextDouble();

        if ((savingsBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Savings Account Balance: " + moneyFormat.format(savingsBalance));
        } else {
            System.out.println("Insufficient Balance. Cannot execute transaction!" + "\n");
        }
    }

    public void getCheckingDepositInput() {
        System.out.println("Checking Account balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount to deposit to Checking Account: ");
        double amount = input.nextDouble();

        calcCheckingWithdraw(amount);
        System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance)); 
    }

    public void getSavingsDepositInput() {
        System.out.println("Checking Account balance: " + moneyFormat.format(savingsBalance));
        System.out.println("Amount to deposit to Checking Account: ");
        double amount = input.nextDouble();

        calcCheckingWithdraw(amount);
        System.out.println("New Savings Account Balance: " + moneyFormat.format(savingsBalance)); 
    }
}

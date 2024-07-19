import java.util.Scanner;

class Account {
    /* I'm going to integrate a DB for storage in this thing... */
    private String accountHolder = null;
    private int accountNumber = 123; //TODO: create serial number generator
    private String accountPassword = null;
    private String PIN = null;
    private boolean accessGrant = false;
    // Employ Composition
    private SavingsAccount savings = null;
    private CheckingAccount checking = null;

    //private AnyType[] accountsOwned;
    Scanner input = new Scanner(System.in);

    public Account() {
        
        System.out.println("Welcome.\n Please create an account to access functionality.");
        System.out.println("Please, provide your Full Name to proceed into account creation: ");
        this.accountHolder = input.nextLine();
        System.out.println("Set a Password and store for safekeeping: ");
        this.accountPassword = input.nextLine();
        System.out.println("Before you go, set a PIN so that you can access your account faster: ");
        this.PIN = input.nextLine();
        System.out.println("Account creation completed.");
    }

    public boolean accountAccessing() {
        System.out.println("Welcome back \n To access your account, please provide your credentials below: ");
        boolean exitFlag = false;
        
        do {
            try {
                System.out.println("Full Name: ");
                String tempName = input.nextLine();
                System.out.println("Password: ");
                String tempPass = input.nextLine();
                if (tempName.equals(accountHolder) && tempPass.equals(accountPassword)) {
                    System.out.printf("It's nice to see you %s", tempName);
                    this.accessGrant = true;
                    exitFlag = true;
                } else {
                    System.out.println("Credentials do not match! Check your syntax?...");
                }
            } catch (Exception e) {
                System.out.println("An error occured. Please, try again.");
            }    
            
        } while (!exitFlag);
        return accessGrant;
    }

    public void accountOpening() {
        /* Ask what kind of account the holder wishes to open. */
        if (accessGrant) {
            double initialBalance = 0;
            String type = "Savings";
            
            switch (type) {
                case "Savings":
                    if (this.savings == null) {
                        this.savings = new SavingsAccount(initialBalance);   
                    } else {
                        System.out.println("A savings account already exists.");
                    }
                    break;
                case "Checking":
                if (this.checking == null) {
                    this.checking = new CheckingAccount(initialBalance);   
                } else {
                    System.out.println("A checking account already exists.");
                }
                break;
                default:
                    System.out.println("Select a valid account type to open.");
                    break;
            }
        }

    }

    public void accountOperations() {
        // TODO: maybe fix the logic of an account's creation?!
        // should the Holder access their accounts here?
    }
    
}

class AnyTypeAccount {
    private double balance;

    public AnyTypeAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void warnNotSufficient () {
        System.out.println("Insufficient balance, transaction aborted...");
    }

    private void performWithdrawal(double amount) {
        balance -= amount;
    }
    private void performDeposit(double amount) {
        balance += amount;
    }

    // add withdrawal method to inherit
    public void makeWithdrawal(double amount) {
        try {
            if ((balance - amount) >= 0) {
                System.out.println("Processing transaction...");
                performWithdrawal(amount);
                System.out.printf("Remaining balance is: %d", balance);
            } else {
                System.out.printf("Insufficient balance. You can withdraw up to: %d", balance);
            }
        } catch (Exception e) {
            System.out.println("Invalid amount. Cannot perform transaction.");
        }
    }

    // add deposit method to inherit
    public void makeDeposit(double amount) {
        try {
            System.out.println("Processing transaction...");
            performDeposit(amount);
            System.out.printf("Updated balance is: %d", balance); 
        } catch (Exception e) {
            System.out.println("Invalid amount. Cannot perform transaction.");
        }
        
    }
}

class CheckingAccount extends AnyTypeAccount{

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }
}

class SavingsAccount extends AnyTypeAccount {

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }
}



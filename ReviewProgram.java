import java.util.Scanner; // for reading user input

public class ReviewProgram {

    private static Scanner input = new Scanner(System.in); // Initialize the scanner object

    public static void main(String[] args) {
        
        //Declare all the variables
        String anotherAccount = "";
        double totalBalance = 0;
        
        do {
        String accNumber = accountNumber();
        String accountType = accountType();
        String custumerName = customerName();
        double accBalance = accountBalance();
        double monthlyFee = monthlyFee(accountType, accBalance);
        printInfo(accNumber, accountType, custumerName, accBalance, monthlyFee);
        
        //Calculate the total balance with each iteration
        totalBalance += accBalance;
        
        System.out.print("\nDo you wish to enter information for another account? (Y/N): ");
        anotherAccount = input.nextLine();

        //Check if the user want to add another account
        } while (!anotherAccount.equalsIgnoreCase("N"));

        //Print the total balance
        System.out.printf("\nThe total balance of all the accounts is: $%,.2f" , totalBalance);
    }

    /**
     * Get the account number from user.
     * @return The account number
     */
    public static String accountNumber() {
        //Declare all variables
        String accNumber;

        //Get the account number
        System.out.print("\nPlease enter the Account Number: ");
        accNumber = input.nextLine();

        return accNumber;
    }

    /**
     * Get and validate a menu option from the user.
     * @return The menu option (Checkings or Savings)
     */
    public static String accountType() {
        //Declare all variables and constants
        final int CHECKING = 1;
        final int SAVINGS = 2;
        int menuOption;
        String accountType;

        //Get the type of account with a menu
        System.out.println("    1. Checking");
        System.out.println("    2. Savings");
        System.out.print("Select an Account Type from the menu above: ");
        menuOption = input.nextInt();
        input.nextLine(); // Consume the newline character


        //Validate the menu option
        while (!(menuOption == CHECKING || menuOption == SAVINGS)) {
            System.out.print("Select an Account Type from the menu above 1 or 2: ");
            menuOption = input.nextInt();
            input.nextLine(); // Consume the newline character
        }

        //Determine in word which type of account
        if (menuOption == CHECKING){
            accountType = "Checking";
        } else {
            accountType = "Savings";
        }

        return accountType;
    }

    /**
     * Get the customer name from user
     * @return customer name
     */
    public static String customerName(){
        //Declare all variables
        String customerName;

        //Get the customer name
        System.out.print("Please enter the Customer's Name: ");
        customerName = input.nextLine();

        return customerName;
    }

    /**
     * Get the account balance from user.
     * @return  account balance
     */
    public static double accountBalance(){
        //Declare all variables and constants
        final int NON_NEGATIVE = 0;
        double accBalance;

        //Get the account balance from user
        System.out.print("Please enter the Account Balance: ");
        accBalance = input.nextDouble();
        input.nextLine(); // Consume the newline character

        //Validate the account balance for negative numbers
        while (accBalance < NON_NEGATIVE){
            System.out.print("Please enter a positive ammount: ");
            accBalance = input.nextDouble(); 
            input.nextLine(); // Consume the newline character
        }

        return accBalance;

    }

    /**
     * Determine the monthly fee
     * @param accountType 
     * @param accBalance
     * @return monthly fee
     */
    public static double monthlyFee(String accountType, double accBalance){
        //Declare all variables and constants
        double monthlyFee = 0;
        
        //Determine the monthly fee
        switch (accountType){
            case "Checking":
                monthlyFee = accBalance * 0.001;
                break;
            case "Savings":
                monthlyFee = 0;
                break;
        }

        return monthlyFee;
    }

    /**
     * Print all the information.
     * @param accNumber 
     * @param accountType
     * @param customerName
     * @param accountBalance
     * @param monthlyFee
     */
    public static void printInfo(String accNumber, String accountType, String customerName, double accountBalance, double monthlyFee){
        System.out.println("\nAccount Number: " +  accNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Customer Name: " + customerName);
        System.out.printf("Account Balance: $%,.2f" , accountBalance);
        System.out.printf("\nMonthly Fee: $%,.2f" , monthlyFee);
    }


}
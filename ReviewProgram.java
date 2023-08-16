import java.util.Scanner; //for reading user input

public class ReviewProgram {
    
    //Initialize the scanner object
    Scanner input = new Scanner(System.in);
    public static void main(String[]  args){ 
       
        accountNumber();
        menuOptions();
    }
public static String accountNumber(){
    //Initialize the scanner object
    Scanner input = new Scanner(System.in);
    String accNumber;
    System.out.print("Please enter the Account Number: ");
    accNumber = input.nextLine();
    return accNumber;
}

public static int menuOptions(){
    //Initialize the scanner object
    Scanner input = new Scanner(System.in);
    int menuOption;
    System.out.println("    1. Checking");
    System.out.println("    2. Savings");
    System.out.print("Select an Account Type from the menu above: ");
    menuOption = input.nextInt();
    while (!(menuOption == 1 || menuOption == 2)){
       System.out.print("Select an Account Type from the menu above: ");
        menuOption = input.nextInt(); 
    }
    return menuOption;
}

}

package Bank.Main;
import java.util.Scanner;

import static Manager.Manage.*;
import static User.Users.userLogin;

public class LogIn {
    static String choice;

    public static Scanner scan = new Scanner(System.in);

    public static void logIn() {
        while (true){
            System.out.print("""
                    >>> Choice the below option
                    \n
                    A. User LogIn
                    B. Manager Login
                    C. Exit!!!
                    \n
                    What do you choice :
                    """);
        choice = scan.nextLine();
        switch (choice) {
            case "A":
                userLogin();
                break;
            case "B":
                managerLogin();
                break;
            case "C":
                System.exit(0);
                break;
            default:
                System.out.println("Sorry! Check your Option");
                break;
        }
    }
}

    public static void main(String[] args) {
        System.out.println("===Welcome to BankMate===");
        logIn();
    }
}





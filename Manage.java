package Manager;

import Accounts.Account;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import static Bank.Main.LogIn.logIn;

public class Manage {
   static HashMap<String,Account> acc=new HashMap();
     static Scanner scan=new Scanner(System.in);
     static   private String m1Id="m";
     static   private String m1Password="m";
     static String choice;

    public static void managerLogin(){
        String dumid;
        String dumpas;
        boolean iscorrect=true;
        System.out.println(" Hi Manager use your Id and Password to take Login . . .\n");
        while(iscorrect){
            System.out.print("Enter Your  ID       : ");
            dumid=scan.nextLine();
            System.out.print("Enter Your  Password : ");
            dumpas=scan.nextLine();
            if(m1Id.equals(dumid) && m1Password.equals(dumpas) ){
                System.out.println("\n ===login Successfully=== \n");
                managerMenu();
                return;
            }else{
                System.out.println("\nSorry! Check your ID & Password...");
                System.out.println("Please Try Again....\n");
            }
        }
    }
    public static void managerMenu(){
        do{
        System.out.println("""
                >>> Choice the below option\n
                A. Create New Account
                B. Search Account 
                C. Delete Account
                D. View All Acounts 
                E. Log Out
                F. Exit!!!\n
                What do you choice :
                """);
        choice=scan.nextLine();
        switch (choice){
            case "A":
                createAccount();
                break;
            case "B":
                searchAccount();
                break;
            case "C":
                deleteAccount();
                break;
            case "D":
                viewAllAccount();
                break;
            case "E":
                logIn();
                break;
            case "F":
                System.exit(0);
                break;
            default:
                System.out.println("Sorry! Check your Option");
                break;
        }
        }while(true);
    }
    public static void createAccount(){
        try {
            String accName;
            String accPassword;
            String accAPhoneN;
            String accAddress;
            double balance;
            long accN;

            while (true) {
                accN = (long) (Math.random() * 10000000);
                FileInputStream fis = new FileInputStream("G:\\Bank\\BankObjects.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                HashMap<String, Account> accdup = null;
                accdup = (HashMap<String, Account>) ois.readObject();
                if (accdup.containsKey(accN)) {
                    continue;
                }
                break;
            }
            String accNumber = String.valueOf(accN);
            while (true) {
                System.out.print("Enter User Name : ");
                accName = scan.nextLine();
                if (accName.matches("^[A-Z][a-zA-Z ]{2,14}$")) {
                    break;
                } else {
                    System.out.println("""
                            Rule:
                            1. First letter must be Capital!
                            2. Name shout be between 3 to 15 characters!
                            3. Special symbols not allowed!
                            
                             Try again...""");
                    continue;
                }
            }
            while (true) {
                System.out.print("Create User Password : ");
                accPassword = scan.nextLine();
                if (accPassword.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*+-?]).{8,15}$")) {
                    break;
                } else {
                    System.out.println("""
                            Rule:
                            1. Length 8-15 characters
                            2. At least 1 uppercase(A-Z)
                            3. At least 1 lowercase(a-z)
                            4. At least 1 digit(0-9)
                            5. At least 1 spacial character
                            Try again...""");
                    continue;
                }
            }
            while (true) {
                System.out.print("Enter User Phone Number : ");
                accAPhoneN = scan.nextLine();
                if (accAPhoneN.matches("^[0-9]{10}$")) {
                    break;
                } else {
                    System.out.println("""
                            Rule:
                            1. must be 10 digits!
                            2.  Alphabets ans special symbol are not allowed!
                            Try again...""");
                    continue;
                }
            }
            while (true) {
                System.out.print("Enter User address : ");
                accAddress = scan.nextLine();
                if (accAddress.matches("^[0-9A-Za-z ,._/#]{10,50}$")) {
                    break;
                } else {
                    System.out.println("""
                            Rule:
                            1. Use (A to Z ans a to z)
                            2. digits (0 to 9)
                            3. Use Space, comma and dot.
                            Try again...""");
                    continue;
                }
            }
            while (true) {
                System.out.print("Enter User Balance : ");
                if (scan.hasNextLong()) {
                    balance = scan.nextDouble(); scan.nextLine();
                    break;
                } else {
                    scan.nextLine();
                    System.out.println("""
                            Rule:
                            1. must be digits!
                            2. No symbols or special character allowed!
                            Try again...""");
                    continue;
                }
        }

                Account newUser = new Account(accNumber, accName, accPassword, accAPhoneN, accAddress, balance);
            HashMap<String,Account> accdup=null;

            FileInputStream fis=new FileInputStream("G:\\Bank\\BankObjects.txt");
            ObjectInputStream ois=new ObjectInputStream(fis);
            accdup=(HashMap<String, Account>)ois.readObject();
//            System.out.println(accdup);
            accdup.put(accNumber, newUser);
                FileOutputStream fos = new FileOutputStream("G:\\Bank\\BankObjects.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(accdup);

                System.out.println("\n New User Account Created Successfully..... \n");
                System.out.println("The User Account Number Is : " + accNumber);

//            managerMenu();

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void searchAccount(){

        try{
            HashMap<String,Account> accdup=null;

            FileInputStream fis=new FileInputStream("G:\\Bank\\BankObjects.txt");
            ObjectInputStream ois=new ObjectInputStream(fis);
            accdup=(HashMap<String, Account>)ois.readObject();

        boolean iscorrect=true;

        while(iscorrect) {
            System.out.print("Enter User Account Number : ");
            String an = scan.nextLine();
           if (accdup.containsKey(an)){
               System.out.println(String.format("%-17s|| %-14s|| %-13s|| %-10s|| %-26s|| %-10s ", "Account Number","Name" ," Password" , " Phone Number ", "Address" ,"Balance  "));
                System.out.println("================================================================================================================");
               Account dup=accdup.get(an);
               System.out.println(dup);
//               managerMenu();
           }else{
               System.out.println("Invalid Account Number !!!");
               System.out.println("try again if you want to exit Enter Cancel or Countinue");
               String cancel=scan.nextLine();
               if("cancel".equalsIgnoreCase(cancel)){
                   return;
               }
           }
        }
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public static void deleteAccount(){
        try {
            HashMap<String,Account> accdup=null;
            FileInputStream fis = new FileInputStream("G:\\Bank\\BankObjects.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            accdup = (HashMap<String, Account>) ois.readObject();
            System.out.println(accdup);
            System.out.println("Which account you want to delete....?");

            while (true) {
                System.out.println(" Enter user Account number to Deleting an Account! :");
                String id = scan.nextLine();

                if (accdup.containsKey(id)) {
                    accdup.remove(id);
                    FileOutputStream fos = new FileOutputStream("G:\\Bank\\BankObjects.txt");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(accdup);
                    System.out.println("Account deleted Successffully");
                    return;
                } else {
                    System.out.println("Invalid Account Number !!!");
                    System.out.println("try again if you want to exit Enter Cancel or Continue");
                    String cancel = scan.nextLine();
                    if ("cancel".equalsIgnoreCase(cancel)) {
                        return;
                    }

                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }
    public static void viewAllAccount(){
        try{
            System.out.println("\nThe All User in our BankMet...\n");
            HashMap<String,Account> accdup=null;
            FileInputStream fis = new FileInputStream("G:\\Bank\\BankObjects.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            accdup = (HashMap<String, Account>) ois.readObject();

            System.out.println(String.format("%-17s|| %-14s|| %-13s|| %-10s|| %-26s|| %-10s ", "Account Number","Name" ," Password" , " Phone Number ", "Address" ,"Balance  "));
            System.out.println("================================================================================================================");
//            for(HashMap hm : accdup) {
              System.out.println(accdup.values());
//            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

// malai 2095990
//srini 5613187
//mani 7079243
//Gopi 6283006
//nambi 8284850
//gopal 5822565
//murugan 5626336
//naveen 9280119
//nandhini 1019486
// arun 7371072
//Susi 3115745
//Vishnu  8901459

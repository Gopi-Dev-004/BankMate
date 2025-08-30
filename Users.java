package User;

import Accounts.Account;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

import static Bank.Main.LogIn.logIn;


public class Users {

    static Scanner scan=new Scanner(System.in);
    static String choice;

   static String dumiacc;
   static String dumpas;

    public static void userLogin(){

        boolean iscorrect=true;
        System.out.println(" Hi User use your Id and Password to take Login . . .\n");
        while(iscorrect){
            System.out.print("Enter Your  ID       : ");
            dumiacc=scan.nextLine();
            System.out.print("Enter Your  Password : ");
            dumpas=scan.nextLine();
try {
    HashMap<String, Account> accdup = null;
    FileInputStream fis = new FileInputStream("G:\\Bank\\BankObjects.txt");
    ObjectInputStream ois = new ObjectInputStream(fis);
    accdup = (HashMap<String, Account>) ois.readObject();

    Account c=accdup.get(dumiacc);

           if(c.getAccPassword().equals(dumpas) && c.getAccNumber().equals(dumiacc) ){
                System.out.println("\n ===login Successfully=== \n");
               userMenu();
                return;
            }else{
                System.out.println("\nSorry! Check your ID & Password...");
                System.out.println("Please Try Again....\n");

            }
} catch (Exception e) {
    System.out.println("\nSorry! Check your ID & Password...");
    System.out.println("Please Try Again....\n");
}
        }
    }
    public static void userMenu(){
        do{
            System.out.println("""
                >>> Choice the below option\n
                A. Deposit
                B. Withdraw
                C. Check Balance
                D. Transfer Money 
                E. Log Out
                F. Exit!!!\n
                What do you choice :
                """);
            choice=scan.nextLine();
            switch (choice){
                case "A":
                    deposit();
                    break;
                case "B":
                    withdraw();
                    break;
                case "C":
                    checkBalance();
                    break;
                case "D":
                    transferMoney();
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
    public static void deposit(){
        long amount;
        try{
            while(true) {
                System.out.println("Enter your Amount to Deposit : ");
                amount = scan.nextLong();
                scan.nextLine();
                if(amount<0 && amount!=0 ){
                    System.out.println("Insufficient amount please try again...!");
                    continue;
                }
                break;
            }
            HashMap<String, Account> accdup = null;
            FileInputStream fis = new FileInputStream("G:\\Bank\\BankObjects.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            accdup = (HashMap<String, Account>) ois.readObject();

            Account a=accdup.get(dumiacc);
           long b=(long)a.getBalance();

            amount+=b;
            a.setBalance(amount);
            FileOutputStream fos = new FileOutputStream("G:\\Bank\\BankObjects.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accdup);
            System.out.println("Deposit Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void checkBalance(){
        try{
            HashMap<String, Account> accdup = null;
            FileInputStream fis = new FileInputStream("G:\\Bank\\BankObjects.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            accdup = (HashMap<String, Account>) ois.readObject();

            Account a=accdup.get(dumiacc);
            System.out.println("Your Balance is : "+ a.getBalance());
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void withdraw(){
        try{
         int amount;
            HashMap<String, Account> accdup = null;
            FileInputStream fis = new FileInputStream("G:\\Bank\\BankObjects.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            accdup = (HashMap<String, Account>) ois.readObject();

            Account a=accdup.get(dumiacc);
        while(true){
            System.out.println("Enter amount to Withdraw : ");
            amount=scan.nextInt();scan.nextLine();
            if(amount<=a.getBalance() && 0<amount ){
                long b=(long)a.getBalance()-amount;
                a.setBalance(b);
                FileOutputStream fos = new FileOutputStream("G:\\Bank\\BankObjects.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(accdup);
                System.out.println("Withdraw Successfully...");
                return;
            }
            System.out.println("Insufficient amount try again...!");
        }
    }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void transferMoney(){
       try{
           Account ta;
           HashMap<String, Account> accdup = null;
           FileInputStream fis = new FileInputStream("G:\\Bank\\BankObjects.txt");
           ObjectInputStream ois = new ObjectInputStream(fis);
           accdup = (HashMap<String, Account>) ois.readObject();
            while(true) {
                System.out.println("Enter Account number to transfer : ");
                String an=scan.nextLine();
                ta = accdup.get(an);
                if(ta==null){
                    System.out.println("Invalid Account Number please try again...");
                    continue;
                }
                break;
                }

           int amount;
           Account a=accdup.get(dumiacc);
           while(true){
               System.out.println("Enter amount to transfer : ");
               amount=scan.nextInt();scan.nextLine();
               if(amount<=a.getBalance() && 0<amount ){
                   long b=(long)a.getBalance()-amount;
                   a.setBalance(b);
                   ta.setBalance(ta.getBalance()+amount);
                   FileOutputStream fos = new FileOutputStream("G:\\Bank\\BankObjects.txt");
                   ObjectOutputStream oos = new ObjectOutputStream(fos);
                   oos.writeObject(accdup);
                   System.out.println("Transfer Successfully...");
                   return;
               }
               System.out.println("Insufficient amount try again...!");
           }
       } catch (Exception e) {
           System.out.println(e);
       }
    }
}

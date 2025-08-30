package Accounts;


import java.io.Serializable;

public class Account implements Serializable {

    private String AccNumber;
    private String AccName;
    private String AccPassword;
    private String AccPhoneN;
    private String AccAddress;
    private double balance;

    public Account() {

    }

    public Account(String accNumber, String accName, String accPassword, String accPhoneN, String accAddress, double balance) {
        AccNumber = accNumber;
        AccName = accName;
        AccPassword = accPassword;
        AccPhoneN = accPhoneN;
        AccAddress = accAddress;
        this.balance = balance;
    }

    public void setAccNumber(String accNumber) {
        AccNumber = accNumber;
    }
    public void setAccName(String accName) {
        AccName = accName;
    }
    public void setAccPassword(String accPassword) {
        AccPassword = accPassword;
    }
    public void setAccPhoneN(String accPhoneN) {
        AccPhoneN = accPhoneN;
    }
    public void setAccAddress(String accAddress) {
        AccAddress = accAddress;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccNumber() {
        return AccNumber;
    }
    public String getAccName() {
        return AccName;
    }
    public String getAccPassword() {
        return AccPassword;
    }
    public String getAccPhoneN() {
        return AccPhoneN;
    }
    public String getAccAddress() {
        return AccAddress;
    }
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("%-17s|| %-14s|| %-13s|| %-14s|| %-26s|| %-10.2f \n",getAccNumber(),getAccName(),getAccPassword(),getAccPhoneN(),getAccAddress(),getBalance());

}
}


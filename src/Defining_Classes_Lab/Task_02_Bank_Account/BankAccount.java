package Defining_Classes_Lab.Task_02_Bank_Account;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02d;

    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountID = 0;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = ++bankAccountID;
    }

    public int getId() {
        return this.id;
    }

    static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

}
package Defining_Classes_Lab.Task_02_Bank_Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<BankAccount> bankAccounts = new ArrayList<>();

        StringBuilder output = new StringBuilder();

        String input;

        while (!"End".equals(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Create": {
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.add(bankAccount);
                    output.append(String.format("Account ID%d created", bankAccount.getId())).append(System.lineSeparator());
                }
                break;
                case "Deposit": {
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    boolean isIDFound = false;

                    for (BankAccount bankAccount : bankAccounts) {
                        if (bankAccount.getId() == id) {
                            bankAccount.deposit(amount);
                            output.append(String.format("Deposited %.0f to ID%d", amount, id)).append(System.lineSeparator());
                            isIDFound = true;
                            break;
                        }
                    }

                    if (!isIDFound) {
                        output.append("Account does not exist").append(System.lineSeparator());
                    }

                }
                break;
                case "SetInterest": {
                    double interestRate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interestRate);
                }
                break;
                case "GetInterest": {
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    boolean isIDFound = false;

                    for (BankAccount bankAccount : bankAccounts) {
                        if (bankAccount.getId() == id) {
                            output.append(String.format("%.2f", bankAccount.getInterest(years))).append(System.lineSeparator());
                            isIDFound = true;
                            break;
                        }
                    }

                    if (!isIDFound) {
                        output.append("Account does not exist").append(System.lineSeparator());
                    }

                }
                break;
                default:
                    throw new IllegalStateException("Unknown value of tokens[0] -> " + tokens[0]);
            }
        }

        System.out.println(output);

    }
}
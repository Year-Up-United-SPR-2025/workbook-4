package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BankAccount.setInterestRate(0.7);

        BankAccount acct1 = new BankAccount("109","Bob", 745.00);
        BankAccount acct2 = new BankAccount("45","Susan", 1000.00);

        String name = "Michael";
        String.format("Hello %s", name);
        int age = Integer.parseInt("35");
        double price = Double.parseDouble("15.95");
    }
}

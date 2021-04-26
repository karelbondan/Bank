package com.assignment.bank;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int option;
        Scanner input = new Scanner(System.in);
        Scanner name = new Scanner(System.in);
        Bank bank = new Bank("Centurion Bank");

        do {
            String firstName;
            String lastName;
            System.out.println("\nWelcome to " + bank.getBankName() + "\n=== Menu ===\n");
            System.out.print("1. New Customer\n2. Existing Customer\n3. Exit\nYour option: ");
            option = input.nextInt();

            if (option == 1) {
                do {
                    System.out.print("\nEnter your first name (type \"q\" to cancel): ");
                    firstName = name.nextLine();
                    firstName = firstName.toUpperCase(Locale.ROOT);
                    System.out.print("Enter your last name (type \"q\" to cancel): ");
                    lastName = name.nextLine();
                    lastName = lastName.toUpperCase(Locale.ROOT);
                    if (bank.customerExist(firstName, lastName))
                        System.out.println("An account with that name already exists. Type \"q\" to access your account.");
                } while (bank.customerExist(firstName, lastName));

                if (firstName.equals("Q") || lastName.equals("Q")) {
                } else {
                    double balance;
                    do {
                        System.out.print("Enter amount of money to be deposited (Min Rp 10,000): Rp ");
                        balance = input.nextDouble();
                    } while (balance < 10000);
                    bank.addCustomer(firstName, lastName);
                    bank.getCustomer(bank.getNumberOfCustomer() - 1).setAccount(new Account(balance));
                }

            } else if (option == 2) {
                System.out.print("\nEnter your first name: ");
                firstName = name.nextLine();
                firstName = firstName.toUpperCase(Locale.ROOT);
                System.out.print("Enter your last name: ");
                lastName = name.nextLine();
                lastName = lastName.toUpperCase(Locale.ROOT);
                boolean customer_exist = bank.customerExist(firstName, lastName);

                if (!customer_exist) System.out.println("You do not have an account in this bank yet\n");
                else {
                    int choose;
                    int index;
                    double amount;
                    do {
                        System.out.println("What do you want to do?");
                        System.out.print("1. Deposit\n2. Withdraw\n3. Balance\n4. Exit\nYour option: ");
                        choose = input.nextInt();
                        if (choose == 1) {
                            index = bank.customerIndex(firstName, lastName);
                            do {
                                System.out.print("Enter amount (type \"0\" to cancel): ");
                                amount = input.nextDouble();
                                if (amount == 0)
                                    break;
                            } while (!bank.getCustomer(index).getAccount().deposit(amount));

                            if (amount == 0) {
                            } else {
                                System.out.println("\nDeposit of Rp " + amount + " succeeded");
                                System.out.println("Your balance is now Rp " + bank.getCustomer(index).getAccount().getBalance() + "\n");
                            }
                        } else if (choose == 2) {
                            index = bank.customerIndex(firstName, lastName);
                            do {
                                System.out.print("Enter amount (type \"0\" to cancel): ");
                                amount = input.nextDouble();
                                if (amount == 0)
                                    break;
                            } while (!bank.getCustomer(index).getAccount().withdraw(amount));

                            if (amount == 0) {
                            } else {
                                System.out.println("\nWithdraw of Rp " + amount + " succeeded");
                                System.out.println("Your balance is now Rp " + bank.getCustomer(index).getAccount().getBalance() + "\n");
                            }
                        } else if (choose == 3) {
                            index = bank.customerIndex(firstName, lastName);
                            System.out.println("You have Rp " + bank.getCustomer(index).getAccount().getBalance() + "\n");
                        }
                    } while (choose != 4);
                }
            }
            else if (option == 3)
                System.out.println("\nThank you for using our service!\n=== " + bank.getBankName() + " ===");
            else
                System.out.println("\nInvalid input\n");
        } while (option != 3);
    }
}

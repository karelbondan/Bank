package com.assignment.bank;

public class Bank {
    private java.util.ArrayList<Customer> customers = new java.util.ArrayList<>();
    private int numberOfCustomer = 0;
    private final String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void addCustomer(String firstName, String lastName) {
        customers.add(new Customer(firstName, lastName));
        numberOfCustomer++;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public String getBankName() {
        return bankName;
    }

    public boolean customerExist(String firstName, String lastName) {
        try {
            for (int i = 0; i <= customers.size() - 1; i++)
                if (getCustomer(i).getFirstName().equals(firstName) && getCustomer(i).getLastName().equals(lastName))
                    return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public int customerIndex(String firstName, String lastName) {
        int index = 0;
        try {
            for (int i = 0; index <= customers.size() - 1; i++) {
                if (getCustomer(i).getFirstName().equals(firstName) && getCustomer(i).getLastName().equals(lastName))
                    break;
                index++;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Customer does not exist");
        }
        return index;
    }
}

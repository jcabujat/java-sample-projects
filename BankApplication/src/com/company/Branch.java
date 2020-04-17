package com.company;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public boolean addCustomer(String name, double amount) {
        if (customerOnFile(name)) {
            System.out.println("Customer " + name + " already listed in this branch.");
            return false;
        }
        Customer newCustomer = new Customer(name, amount);
        this.customers.add(newCustomer);
        return true;
    }

    public boolean addTransaction(String name, double amount) {
        if (!customerOnFile(name)) {
            System.out.println("Customer " + name + " not yet listed on this branch.");
            return false;
        }
        int index = customerIndex(name);
        Customer customer = this.customers.get(index);
        customer.addTransaction(amount);
        return true;
    }

    public void printCustomer(String name, boolean printTransactions) {
        if (!customerOnFile(name)) {
            System.out.println("Customer " + name + " not yet listed on this branch.");
            return;
        }
        int index = customerIndex(name);
        Customer customer = this.customers.get(index);
        System.out.println("Customer name: " + customer.getName());
        if (printTransactions) {
            customer.printTransactions();
        }
    }

    public boolean customerOnFile(String name) {
        if (customerIndex(name) >= 0) {
            return true;
        }
        return false;
    }

    private int customerIndex(String name) {
        if (this.customers.size() <= 0) {
            return -1;
        }
        for (int i = 0; i < this.customers.size(); i++) {
            Customer customer = this.customers.get(i);
            if (customer.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String getBranchName() {
        return branchName;
    }
}

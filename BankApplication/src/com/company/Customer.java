package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double amount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction (double amount) {
        this.transactions.add(amount);
    }

    public void printTransactions () {
        for (int i=0; i<transactions.size(); i++) {
            double amount = transactions.get(i);
            System.out.println("Transaction amount " + i + ": " + amount);
        }
    }

}

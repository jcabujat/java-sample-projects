package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Bank bank = new Bank("BPI");
        bank.addBranch("Pioneer");
        Branch branch = bank.getBranch("Pioneer");
        branch.addCustomer("Jo",100.50);
        branch.addCustomer("Aiza", 500.98);
        branch.addTransaction("Jo",1000.15);
        branch.printCustomer("Jo",true);
        branch.printCustomer("Aiza",true);
        branch.printCustomer("Jo",false);
        branch.printCustomer("Aiza",false);
        branch.addTransaction("Kuys",1000.15);
        branch.printCustomer("Kuys",false);
    }
}

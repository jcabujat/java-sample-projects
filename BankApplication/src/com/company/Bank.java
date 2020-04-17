package com.company;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
    }

    public void addBranch(String branchName) {
        this.branches.add(new Branch(branchName));
    }

    public String getBankName() {
        return bankName;
    }

    public Branch getBranch(String branchName) {
        int index = branchIndex(branchName);
        if (index >= 0) {
            return this.branches.get(index);
        }
        return null;
    }

    private int branchIndex(String name) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if (branch.getBranchName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}

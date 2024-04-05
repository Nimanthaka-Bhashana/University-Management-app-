package com.example.mainactivity;

public class Branch {
    private int id;
    private String branchName;
    private String branchCode;

    public Branch() {
        // Default constructor
    }

    public Branch(int id, String branchName, String branchCode) {
        this.id = id;
        this.branchName = branchName;
        this.branchCode = branchCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
}
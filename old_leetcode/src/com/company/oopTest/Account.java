package com.company.oopTest;

/**
 * @author cz
 * @Description
 * @date 2021/12/15 15:03
 **/
public class Account {
    private int id;
    private double balance;
    private double rate;
    public void getInfo(){
        System.out.println("Account Info");
    }

    public void withdraw(double amount){
        if(amount < balance){
            System.out.println("no enough money");
            return;
        }
        this.balance = this.balance - amount;
        System.out.println("left: " + this.balance );
    }

    public void deposit(double amount){
        this.balance = this.balance + amount;
    }

    public Account(int id, double balance, double rate) {
        this.id = id;
        this.balance = balance;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}

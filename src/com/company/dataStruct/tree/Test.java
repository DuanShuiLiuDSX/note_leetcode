package com.company.dataStruct.tree;

/**
 * @author cz
 * @Description
 * @date 2021/12/13 16:33
 **/

public class Test {
    private Integer id;
    private double balance;
    private double rate;

    public void withDraw(Double money){
        if(money > this.balance){
            System.out.println("No enough money");
        }else {
            this.balance -= money;
        }
    }

    public void deposit(Double money){
        this.balance += money;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
package com.company.oopTest.day18;

/**
 * @author cz
 * @Description
 * @date 2021/12/27 20:16
 **/
public class Account {
    private int id;
    private String pwd = "000000";

    private static int init;
    private static double rate;

    public static double getRate() {
        return rate;
    }

    public static void setRate(double rate) {
        Account.rate = rate;
    }

    public static void setId(int id) {
        id = init++;
    }

    public int getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Account() {
    }

    public Account(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}

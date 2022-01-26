package com.company.oopTest;

/**
 * @author cz
 * @Description
 * @date 2021/12/15 14:40
 **/
public class Test {

    public static void main(String[] args) {
        CheckAccount checkAccount = new CheckAccount(1, 1000.0, 1, 500.0);
        checkAccount.withdraw(1499.01);
        Account account = new CheckAccount(1, 1000.0, 1, 500.0);
        account.getInfo();
    }
}

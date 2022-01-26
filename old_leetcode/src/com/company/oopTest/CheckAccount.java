package com.company.oopTest;

/**
 * @author cz
 * @Description
 * @date 2021/12/15 15:08
 **/
public class CheckAccount extends Account{
    private double overDaft;

    @Override
    public void getInfo() {
        System.out.println("CheckAccount Info");
    }

    public CheckAccount(int id, double balance, double rate, double overDaft) {
        super(id, balance, rate);
        this.overDaft = overDaft;
    }

    @Override
    public void withdraw(double amount) {
        if (amount< super.getBalance()){
            super.withdraw(amount);
        }else if ((amount-super.getBalance()) <= overDaft){
            this.setBalance(super.getBalance()-amount);
            System.out.println("欠费:" + this.getBalance());
        }else{
            System.out.println("超支");
        }
    }

    public CheckAccount(int id, double balance, double rate) {
        super(id, balance, rate);
    }
}

package com.company.oopTest;

/**
 * @author cz
 * @Description
 * @date 2021/12/15 18:56
 **/
public class Sub extends Base{
    private int count = 20;

    @Override
    public void info() {
        System.out.println("Sub:" + this.count);
    }
}

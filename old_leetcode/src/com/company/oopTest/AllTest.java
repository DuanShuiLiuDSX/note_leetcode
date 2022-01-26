package com.company.oopTest;

import com.company.oopTest.day18.Account;
import org.junit.jupiter.api.Test;
/**
 * @author cz
 * @Description
 * @date 2021/12/15 17:08
 **/
public class AllTest {

    @Test
    public void Test1(){
        double data = 12.2;
        long l_data = (long) data;
        System.out.println(l_data);
    }

    /**
     *
     */
    @Test
    public void test2(){
        Sub sub = new Sub();
        sub.info();
        Base base = new Base();
        base = sub;
        System.out.println(base==sub);
        //方法会被重写 属性不会
        System.out.println(base.count);
        base.info();
    }

    public Boolean equalAreas(GeometricObject g1, GeometricObject g2){
        return g1.findArea() == g2.findArea();
    }

    @Test
    public void test3(){
        Circle c1 = new Circle("red", 1, 1);
        Circle c2 = new Circle("green", 1.1, 2);
        System.out.println(equalAreas(c1, c2));
    }

    @Test
    public void test4() {
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1==p2);
        }

    @Test
    public void test5(){
        char[] arr = new char[] { 'a', 'b', 'c' };
        System.out.println(arr);//
        int[] arr1 = new int[] { 1, 2, 3 };
        System.out.println(arr1);//
        double[] arr2 = new double[] { 1.1, 2.2, 3.3 };
        System.out.println(arr2);//
        char ch2 = 12;
        System.out.println(ch2==12);
    }

    public void method(int a){
    }

    public void method2(Integer a){
    }

    @Test
    public void test6(){
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);
        int i =1;
        Integer i1 = new Integer("1");
        method(i1);
        method2(i);

        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);//
    }

    @Test
    public void test7(){
        Account a1 = new Account();
        Account a2 = new Account("123456");
        a2.setRate(1.1);
        a1.toString();
        a2.toString();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1.getRate());
        System.out.println(a2.getRate());
    }


}

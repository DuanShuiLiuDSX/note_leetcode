package com.company.oopTest;

/**
 * @author cz
 * @Description
 * @date 2021/12/15 14:36
 **/
public class Person {
    protected  String name="p1";
    protected int age;
    public String getInfo(){
        return "name: " + name + " age: " +age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}

package com.company.oopTest;

import java.util.Date;

/**
 * @author cz
 * @Description
 * @date 2021/12/15 14:55
 **/
public class Man {
    private String name;
    private int age;
    private Date date;

    public Man(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public Man(String name, int age){
        this(name, age , null);
    }

    public Man(String name){
        this(name, 18);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

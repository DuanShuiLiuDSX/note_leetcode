package com.company.oopTest;

/**
 * @author cz
 * @Description
 * @date 2021/12/15 14:38
 **/
public class Student extends Person{
    protected String name = "s1";
    private String school = "old school";

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    public String getName() {
        return super.getInfo() + " school:" +school;
    }

    public String getSchool() {
        return school;
    }

}

package com.company.oopTest;

/**
 * @author cz
 * @Description
 * @date 2021/12/15 19:53
 **/
public class Circle extends GeometricObject{
    private double radius;
    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return Math.PI*radius*radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

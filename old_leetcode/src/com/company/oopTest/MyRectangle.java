package com.company.oopTest;

/**
 * @author cz
 * @Description
 * @date 2021/12/15 19:56
 **/
public class MyRectangle extends GeometricObject {
    private double width;
    private double height;
    public MyRectangle(String color, double weight, double width, double height) {
        super(color, weight);
        this.height = height;
        this.width = width;
    }

    @Override
    public double findArea() {
        return 0.5*width*height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

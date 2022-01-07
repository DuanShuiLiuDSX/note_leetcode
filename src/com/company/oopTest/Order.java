package com.company.oopTest;

import java.util.Objects;

/**
 * @author cz
 * @Description
 * @date 2021/12/22 14:35
 **/
public class Order {
    private int orderId;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getOrderId() == order.getOrderId() && Objects.equals(getName(), order.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getName());
    }

    public Order(int orderId, String name) {
        this.orderId = orderId;
        this.name = name;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

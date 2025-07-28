package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Order {

    private String orderId;
    private Cart cart;
    private OrderStatus orderStatus;
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", cart=" + cart +
                ", orderStatus=" + orderStatus +
                ", user=" + user +
                '}';
    }

    public Order(Cart cart, User user){
        this.orderId = UUID.randomUUID().toString();
        this.cart = cart;
        this.user = user;
        this.orderStatus = OrderStatus.NEW;
    }
}

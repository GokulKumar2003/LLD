package org.example.service;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.Cart;
import org.example.entity.Order;
import org.example.entity.OrderStatus;
import org.example.entity.User;
import org.example.strategies.payment.PaymentStrategy;
import org.example.strategies.payment.UPIPaymentStrategy;

@Getter
@Setter
public class OrderService {

    PaymentStrategy paymentStrategy;
    public OrderService(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public Order createOrder(User user){
        Order order = new Order(user.getCart(), user);
        return order;
    }

    public Order proceedToPayment(Order order){
        double amt = order.getCart().calculateAmount();
        paymentStrategy.pay(amt);
        order.setOrderStatus(OrderStatus.CONFIRMED);
        order.getUser().getCart().getItems().clear();

        return order;
    }

}

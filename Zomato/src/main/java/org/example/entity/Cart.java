package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class Cart {

    private String cartId;
    private Map<Restaurant, Map<MenuItem, Integer>> items;

    public Cart(){
        this.cartId = UUID.randomUUID().toString();
        items = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", items=" + items +
                '}';
    }

    public double calculateAmount(){

        return items.values().stream()
                .flatMap(menuMap -> menuMap.entrySet().stream())
                .mapToDouble(entry -> entry.getKey().getPrice()*entry.getValue())
                .sum();

    }
}

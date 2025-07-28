package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.service.RestaurantService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Restaurant {

    private String restaurantId;
    private String name;
    private Address address;
    private boolean isOpen;
    private boolean isVeg;
    private List<MenuItem> menu;

    public Restaurant(String name, Address address, Boolean isVeg){
        this.restaurantId = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.isVeg = isVeg;
        this.menu = new ArrayList<>();
        this.isOpen = false;
    }

    public void addMenu(MenuItem item){
        menu.add(item);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId='" + restaurantId + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", isOpen=" + isOpen +
                ", isVeg=" + isVeg +
                ", menu=" + menu +
                '}';
    }
}

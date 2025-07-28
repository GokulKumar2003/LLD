package org.example;

import org.example.entity.*;
import org.example.entity.MenuItem;
import org.example.service.OrderService;
import org.example.service.RestaurantService;
import org.example.strategies.payment.UPIPaymentStrategy;

import java.awt.*;
import java.util.Iterator;
import java.util.UUID;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Address address1 = new Address("1234", "1", "Ram Street", "Rasipuram"
                , "Rasipuram", Long.valueOf(637401));
        Address address2 = new Address("67898", "1", "Lakshman Street",
                "Rasipuram"
                , "Rasipuram", Long.valueOf(637401));
        Address address3 = new Address("4321", "A", "Anna Salai", "Salem",
                "Salem", Long.valueOf(637310));

        Restaurant r1 =  new Restaurant("Amman Hotel",
                address1, false);
        Restaurant r2 = new Restaurant("Saravana Bhavan", address2, true);
        Restaurant r3 = new Restaurant("Anjappar", address3, false);

        MenuItem item1 = MenuItem.builder().menuId(UUID.randomUUID().toString())
                .name("Chicken Briyani")
                .description("Delicious Briyani made in Basmat rice with " +
                        "juicy chicken")
                .price(200)
                .isVeg(false)
                .category(Category.MAIN_COURSE)
                .build();
        MenuItem item2 = MenuItem.builder()
                .menuId(UUID.randomUUID().toString())
                .name("Mutton Briyani")
                .description("Delicious mutton briyani made with jeera rice")
                .price(300)
                .isVeg(false)
                .category(Category.MAIN_COURSE)
                .build();
        MenuItem item3 = MenuItem.builder()
                .menuId(UUID.randomUUID().toString())
                .name("Mutton Briyani")
                .description("Delicious mutton briyani made with jeera rice")
                .price(300)
                .isVeg(false)
                .category(Category.MAIN_COURSE)
                .build();

        MenuItem item4 = MenuItem.builder()
                .menuId(UUID.randomUUID().toString())
                .name("Idly")
                .description("2 pcs idly served with cocunut chutney and " +
                        "sambar")
                .price(80)
                .isVeg(true)
                .category(Category.MAIN_COURSE)
                .build();

        MenuItem item5 = MenuItem.builder()
                .menuId(UUID.randomUUID().toString())
                .name("Dosa")
                .description("Dosa served with cocunut chutney and " +
                        "sambar")
                .price(120)
                .isVeg(true)
                .category(Category.MAIN_COURSE)
                .build();

        r1.addMenu(item1);
        r1.addMenu(item2);
        r3.addMenu(item3);
        r2.addMenu(item4);
        r2.addMenu(item5);

        RestaurantService restaurantService = new RestaurantService();
        restaurantService.addRestaurant(r1);
        restaurantService.addRestaurant(r2);
        restaurantService.addRestaurant(r3);


        List<Restaurant> restaurantList =
                restaurantService.getRestaurant("Rasipuram");
        Iterator<Restaurant> iterator = restaurantList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }


        List<Restaurant> SalemRestaurantList =
                restaurantService.getRestaurant("Salem");
        Iterator<Restaurant> iterator2 = SalemRestaurantList.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next().toString());
        }

        Address address4 = new Address("abcd", "1A", "SRV Garden", "Rasipuram", "Rasipuram", Long.valueOf(637401));
        User user = new User("Gokul", address4, "1234567890");
        restaurantService.addItem(user, r1, item1, 1);
        restaurantService.addItem(user, r1, item2, 2);
        restaurantService.addItem(user, r2, item4, 1);

        OrderService orderService = new OrderService(new UPIPaymentStrategy());
        Order order = orderService.createOrder(user);
        System.out.println("Before Payment");
        System.out.println(order.toString());
        orderService.proceedToPayment(order);

        System.out.println("After payment");
        System.out.println(order.toString());

    }
}
package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter

public class RestaurantService {

    Map<String, List<Restaurant>> restaurantList;
    Map<String, Restaurant> restaurantMap; // id -> Restaurant

    public RestaurantService(){
        restaurantList = new HashMap<>();
        restaurantMap = new HashMap<>();
    }

    public Restaurant addRestaurant(Restaurant restaurant){


        if(restaurantList.containsKey(restaurant.getAddress().getCity().toLowerCase())){
            restaurantList.get(restaurant.getAddress().getCity().toLowerCase()).add(restaurant);
        }
        else{
            restaurantList.put(restaurant.getAddress().getCity().toLowerCase(), new ArrayList<>(List.of(restaurant)));
        }
        restaurantMap.put(restaurant.getRestaurantId(), restaurant);
        return restaurant;
    }

    public List<Restaurant> getRestaurant(String city){
        if(restaurantList.containsKey(city.toLowerCase())){
            return restaurantList.get(city.toLowerCase());
        }
        return new ArrayList<>();
    }

    public Restaurant makeRestaurantActive(String restaurantId){
        Restaurant restaurant = restaurantMap.get(restaurantId);
        restaurant.setOpen(true);
        Restaurant restaurant1 =
                restaurantList.get(restaurant.getAddress().getCity().toLowerCase()).stream()
                        .filter(r -> r.getRestaurantId().equals(restaurant.getRestaurantId()))
                        .findFirst()
                        .orElse(null);

        restaurant1.setOpen(true);

        return restaurant1;
    }

    public void addItem(User user, Restaurant restaurant, MenuItem item,
                        Integer quantity){
        Cart userCart = user.getCart();
        if(userCart.getItems().containsKey(restaurant)){
            userCart.getItems().get(restaurant).put(item, quantity);
        }
        else{
            Map<MenuItem, Integer> m = new HashMap<>();
            m.put(item, quantity);
            userCart.getItems().put(restaurant, m);
        }
    }
}

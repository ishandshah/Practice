/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.coinbase.orderingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantMain {


    public static void main(String[] args) {


    // Create menu items
    MenuItem pizza = new MenuItem("Pizza", 10.0);
    MenuItem pizz2 = new MenuItem("Pizza", 1.0);
    MenuItem burger = new MenuItem("Burger", 8.0);

    // Create restaurants
    List<MenuItem> menu1 = new ArrayList<>();
     menu1.add(pizza);

    List<MenuItem> menu2 = new ArrayList<>();
        menu2.add(burger);
        menu2.add(pizz2);

    List<MenuItem> menu3 = new ArrayList<>();
        menu3.add(pizza);
        menu3.add(burger);

    Restaurant r1 = new Restaurant("Pizza Palace", menu1, 30);
    Restaurant r2 = new Restaurant("Burger Bistro", menu2, 20);
    Restaurant r3 = new Restaurant("Fast Food Express", menu3, 15);

    // Create a list of restaurants
    List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(r1);
        restaurantList.add(r2);
        restaurantList.add(r3);

        // Create RestaurantList object
        RestaurantList restaurants = new RestaurantList(restaurantList);

        // Find the cheapest restaurant for "Pizza"
        Optional<Restaurant> cheapestRestaurant = restaurants.findCheapest("Pizza");
        if (cheapestRestaurant.isPresent()) {
            System.out.println("Cheapest restaurant for Pizza: " + cheapestRestaurant.get().getRestaurantName());
        } else {
            System.out.println("Pizza is not available.");
        }

        // Find the fastest delivery restaurant for "Pizza"
        Optional<Restaurant> fastestRestaurant = restaurants.findFastestDelivery("Pizza");
        if (fastestRestaurant.isPresent()) {
            System.out.println("Fastest delivery restaurant for Pizza: " + fastestRestaurant.get().getRestaurantName());
        } else {
            System.out.println("Pizza is not available.");
        }

    }
}

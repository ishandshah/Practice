/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.coinbase.orderingSystem;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RestaurantList {
    List<Restaurant> restaurants;


    public Optional<Restaurant> findCheapest(String item){
        return restaurants.stream()
                .filter(restaurant -> restaurant.getPrice(item).isPresent())
                .min(Comparator.comparingDouble(restaurant->restaurant.getPrice(item).orElse(Double.MAX_VALUE)));

    }
    public Optional<Restaurant> findFastestDelivery(String item){
        return restaurants.stream().filter(restaurant -> restaurant.getPrice(item).isPresent())
                .min(Comparator.comparingInt(restaurant->restaurant.getDeliveryTime()));

    }
}

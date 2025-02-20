/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.coinbase.orderingSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Data
public class Restaurant {

    String restaurantName;

    List<MenuItem> menuItemList;

    int deliveryTime;

    public Optional<Double> getPrice(String itemName){
        for(MenuItem menuItem:menuItemList){
            if(itemName.equalsIgnoreCase(menuItem.itemName)){
                return Optional.of(menuItem.itemPrice);
            }
        }
        System.out.println("Price not found");
        return Optional.empty();
    }

    public int getDeliveryTime(){
        return this.deliveryTime;
    }
}

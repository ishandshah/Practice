/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.coinbase.tradingSystem;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Order> buyOrders;
    private List<Order> sellOrders;

    public Market() {
        this.buyOrders = new ArrayList<>();
        this.sellOrders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        if (order.getType() == Order.Type.BUY) {
            buyOrders.add(order);
            matchOrders();
        } else {
            sellOrders.add(order);
            matchOrders();
        }
    }

    private void matchOrders() {
        for (Order buyOrder : new ArrayList<>(buyOrders)) {
            for (Order sellOrder : new ArrayList<>(sellOrders)) {
                if (sellOrder.getPrice() <= buyOrder.getPrice() && sellOrder.getQuantity() > 0 && buyOrder.getQuantity() > 0) {
                    int quantityToTrade = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());
                    System.out.println("Matched: " + quantityToTrade + " of " + sellOrder.getStock().getName() +
                            " at price " + sellOrder.getPrice());

                    buyOrder.reduceQuantity(quantityToTrade);
                    sellOrder.reduceQuantity(quantityToTrade);

                    if (sellOrder.isCompleted()) {
                        sellOrders.remove(sellOrder);
                    }
                    if (buyOrder.isCompleted()) {
                        buyOrders.remove(buyOrder);
                    }

                    // Break after a successful match to avoid ConcurrentModificationException
                    break;
                }
            }}}
}

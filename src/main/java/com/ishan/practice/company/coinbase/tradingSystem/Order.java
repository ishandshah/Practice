/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.coinbase.tradingSystem;

public class Order {
    public enum Type {
        BUY,
        SELL
    }

    private Type type;
    private Stock stock;
    private double price;
    private int quantity;

    private User user;

    public Order(Type type, Stock stock, double price, int quantity) {
        this.type = type;
        this.stock = stock;
        this.price = price;
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public Stock getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    public boolean isCompleted() {
        return quantity <= 0;
    }
}


/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.lamda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class TestNov25 {
    public enum OrderType{
        ONLINE,
        STORE
    }

    public static void main(String[] args) {
        List<Order> orderList=new ArrayList<>();
        TestNov25 tst=new TestNov25();

        for(int i=0;i<100;i++){
            orderList.add(tst.addOrder(i));
        }

        int sum =

                orderList.
                        //Creates Stream instance
                        stream().
                        //Adds a filter operation
                filter(x -> x.type != "ONLINE").
                        // Map operation on the filtered data
                        mapToInt(Order::getQuantity).
                        //Terminal operation to finish the processing
                        sum();
        System.out.println(sum);

        LongStream.range(0,5).forEach(System.out::println);

   orderList.stream().max(Comparator.comparingInt(x -> x.getQuantity())).ifPresent(x->System.out.println(x.getQuantity()));


   List<Integer> quantityList=orderList.stream().map(Order::getQuantity).collect(Collectors.toList());
    }

    private Order addOrder(int i) {
        String[] orderTypeArray={"ONLINE","STORE"};
        return new Order(new Random().nextInt(0,100),orderTypeArray[i%2]);
    }

    class Order{

        int quantity;
        String type;

        public Order(int quantity, String type) {
            this.quantity = quantity;
            this.type = type;
        }

        public Order() {

        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}



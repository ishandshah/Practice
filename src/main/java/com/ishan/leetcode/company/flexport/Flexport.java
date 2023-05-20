/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.flexport;


/* Given a shipping yard with infinite capacity for containers and has clients who would like to store their containers.
Design a system which can manage the operations of the yard.

Start with a client intending to add or remove containers, i.e. (containers, amount)
Improve functionality by extending the system to buying and selling operations,
maintain a order book where logs of each buy and sell order requests are logged
introduce bidding for each buy and sell request, based on the best offer, make the transaction.

*/

import java.util.*;
import java.util.function.BiFunction;


public class Flexport {


    Map<String, Map<String,Integer>> clientToContainerMap=new HashMap<>();
    Queue<Order> buyOrder=new LinkedList<>();
    Queue<Order> sellOrder=new LinkedList<>(){
        @Override
        public boolean contains(Object o) {
            for (Order k : sellOrder) {
               if( k.isAvailable && k.price == ((Order) o).price){
                   return true;
               }
            }
            return false;
        }
    };

    List<Order> orderList=new ArrayList<>();


    Map map = new TreeMap<>(new OrderComparator());

    public boolean addContainer(String clientId,String containerId,int quantity){
        BiFunction<Integer, Integer, Integer> powFunction = (x1, x2) -> Math.addExact(x1, x2);

        if(clientToContainerMap.containsKey(clientId)){
            clientToContainerMap.get(clientId).merge(containerId,quantity,(k,v) -> powFunction.apply(quantity,clientToContainerMap.get(clientId).get(containerId)));
        }else{
            clientToContainerMap.put(clientId,new HashMap<>(){{
                put(containerId,quantity);
            }});
        }


        return false;
    }

    public boolean removeContainerQuantity(String clientId,String containerId,int quantity){
        //BiFunction<Integer, Integer, Integer> powFunction = (x1, x2) -> Math.subtractExact(x2, x1);

        if(clientToContainerMap.containsKey(clientId) && clientToContainerMap.get(clientId).containsKey(containerId)){
            //clientToContainerMap.get(clientId).merge(containerId,quantity,(k,v) -> powFunction.apply(quantity,clientToContainerMap.get(clientId).get(containerId)));
            clientToContainerMap.get(clientId).replace(containerId,clientToContainerMap.get(clientId).get(containerId) - quantity);
            return true;
        }
        return false;
    }

    public boolean removeContainer(String clientId,String containerId){
        //BiFunction<Integer, Integer, Integer> powFunction = (x1, x2) -> Math.subtractExact(x2, x1);

        if(clientToContainerMap.containsKey(clientId) && clientToContainerMap.get(clientId).containsKey(containerId)){
            clientToContainerMap.get(clientId).remove(containerId);
            return true;
        }
        return false;
    }


    public boolean buyOrder(Order order1){
        orderList.add(order1);
        if(sellOrder.contains(order1)){
            sellOrder.remove(order1);
            return true;
        }
        buyOrder.offer(order1);

        return false;
    }

    public void sellOrder(Order order1){
        orderList.add(order1);
      sellOrder.offer(order1);
     //   return false;
    }

    public static void main(String[] args) {
        String clientId="Ishan";
        String containerId="ishan's container";
        int quantity=5;


        String clientId2="SIshan";
        String containerId2="2ishan's container";
        int quantity2=5;
        Flexport fle=new Flexport();

        fle.addContainer(clientId,containerId,quantity);
        fle.addContainer(clientId,containerId,10);
        fle.addContainer(clientId2,containerId2,quantity2);
        fle.removeContainerQuantity(clientId,containerId,1);

        fle.removeContainer(clientId2,containerId2);
        Order sellOrder=new Order(Boolean.TRUE,12.12f,"himani");
        fle.sellOrder(sellOrder);
        Order buyOrder=new Order(Boolean.FALSE,12.12f,"ishan");
        fle.buyOrder(buyOrder);

        buildBidding();


    }

    private static void buildBidding() {


    }

    private static class Order {


        String orderId;
        boolean isAvailable;

        float price;

        String clientId;

        public Order(boolean isAvailable, float price, String clientId) {
            this.isAvailable = isAvailable;
            this.price = price;
            this.clientId = clientId;
            this.orderId= UUID.randomUUID().toString();
        }
    }

    private class OrderComparator implements Comparator<Order>{

        @Override
        public int compare(Order o1, Order o2) {
            if(o1.price>o2.price){
                return -1;
            }else{
                return 1;
            }
        }
    }
}

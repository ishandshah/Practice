/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;


//sure 2:1 VIP
public class ServiceScheduler {
    public Queue<Customer> vipList = new LinkedList<>();
    public Queue<Customer> regularList = new LinkedList<>();
    private int vipCount = 0;


    public void checkIn(Customer customer) {
        customer.checkinTime = System.currentTimeMillis();
        if (customer.isVip) {
            vipList.add(customer);
        } else {
            regularList.add(customer);
        }
    }

    public Customer getNextCustomer() {
        if (!vipList.isEmpty() && vipCount < 2) {
            vipCount++;
            return vipList.poll();
        }
        vipCount = 0;
        return regularList.poll();
    }
}


@Data
@AllArgsConstructor
class Customer {

    String customerName;

    boolean isVip;

    long checkinTime;
}
/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.queue;

import java.util.PriorityQueue;

/* Again Prioirity queue because I have forgotten how to do it :D


 */
public class PriorityQueueColorExample implements Comparable<PriorityQueueColorExample>{


    private int value;
    private String color;

    public PriorityQueueColorExample(int value, String color) {
        this.value = value;
        this.color = color;
    }

    //static PriorityQueue<PriorityQueueColorExample> queue=new PriorityQueue<>();

    public static void main(String[] args) {

        PriorityQueue<PriorityQueueColorExample> queue = new PriorityQueue<>();


        queue.add(new PriorityQueueColorExample(1,"black"));
        queue.add(new PriorityQueueColorExample(2,"redish"));
        queue.add(new PriorityQueueColorExample(3,"bluek"));
        queue.add(new PriorityQueueColorExample(4,"redol"));
        queue.add(new PriorityQueueColorExample(5,"RED"));

        System.out.println(queue.peek().color + queue.peek().value);
    }




    @Override
    public int compareTo(PriorityQueueColorExample o) {
        if ((this.color.equals("red") && o.color.equals("red")) ||
                (!this.color.equals("red") && !o.color.equals("red"))) {
            return Integer.compare(this.value, o.value);
        }
        else if (this.color.equals("red")) {
            return -1;
        }
        else {
            return 1;
        }
    }
}



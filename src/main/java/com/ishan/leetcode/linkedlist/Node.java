/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.linkedlist;

public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;

    }

    public static void print(Node head) {

        //Node current=head;


        while (head != null) {
            System.out.println(head.value);
            head = head.next;
            //reverse the connection/arros

        }

    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.linkedlist;

import java.util.Random;

public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;

    }

    public static Node populateLinkedList(int value){
        Node head=new Node(value);
        head.next=new Node(new Random().nextInt(0,100));
        head.next.next=new Node(new Random().nextInt(0,100));;
        head.next.next.next=new Node(new Random().nextInt(0,100));
        head.next.next.next.next=new Node(new Random().nextInt(0,100));
        head.next.next.next.next.next=new Node(new Random().nextInt(0,100));
        head.next.next.next.next.next.next=new Node(new Random().nextInt(0,100));
        head.next.next.next.next.next.next.next=new Node(new Random().nextInt(0,100));


        return head;

    }

    public static void print(Node head) {

        //Node current=head;


        while (head != null) {
            System.out.println(head.value);
            head = head.next;
            //reverse the connection/arrows

        }

    }
}

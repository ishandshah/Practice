/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.linkedlist;

public class Reversealinkedlist {


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);


        Node prev = printReverse(head);
        while (prev != null) {
            System.out.println(prev.value);
            prev = prev.next;
        }
    }

    private static Node printReverse(Node head) {

        //Node current=head;
        Node next;
        Node prev = null;


        while (head != null) {
            next = head.next;
            //reverse the connection/arros
            head.next = prev;
            prev = head;
            head = next;

        }
        return prev;
    }


}


/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct23;

import com.ishan.leetcode.linkedlist.Node;

//https://leetcode.com/problems/middle-of-the-linked-list/description/
public class MiddleLinkedList {
    public Node middleNode(Node head) {

        Node slow=head;
        Node fast=head;

        while(fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       return slow;
    }
}

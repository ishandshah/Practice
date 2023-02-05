/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */


package com.ishan.leetcode.linkedlist;

public class MergeTwoSorted {
    Node sortedMerge(Node headA, Node headB) {
        Node dummy = new Node(Integer.MIN_VALUE);
        Node tail = dummy;
        while (headA.next != null || headB.next != null) {

            if (headA == null) {

                tail = headB;
            }

            if (headB == null
            ) {
                tail = headA;
            }

            if (headB.value > headA.value) {
                tail.next = headB;
                headB = headB.next;
            } else {
                tail.next = headA;
                headB = headB.next;
            }

            tail = tail.next;
        }


        return dummy.next;
    }
}

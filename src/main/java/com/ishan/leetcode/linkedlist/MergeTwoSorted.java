/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */


package com.ishan.leetcode.linkedlist;

public class MergeTwoSorted {
    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(4);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);
        l2.next.next.next = new Node(40);
        Node l3 = new MergeTwoSorted().sortedMerge(l1, l2);
        Node.print(l3);
    }

    com.ishan.leetcode.linkedlist.Node sortedMerge(com.ishan.leetcode.linkedlist.Node l1, com.ishan.leetcode.linkedlist.Node l2) {

        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        Node dummy = new Node(-10);
        Node curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct14;

import com.ishan.leetcode.linkedlist.Node;


//TODO Revisit
//https://leetcode.com/problems/merge-two-sorted-lists/description/
public class MergeSortedList {
    public static void main(String[] args) {
        Node head1 = Node.populateLinkedList(10);
        Node.print(head1);
        System.out.println("New list");
        Node head2 = Node.populateLinkedList(12);
        Node.print(head2);
        Node node = mergeTwoLists(head1, head2);
        System.out.println("Result list");
        Node.print(node);
    }

    public static Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        Node head1 = list1;
        Node head2 = list2;
        Node newHead = new Node(-1);
        Node curr = newHead;
        while (head1 != null && head2 != null) {

            if (head1.value >= head2.value) {
                curr.next = head2;
                head2 = head2.next;
            } else {
                curr.next = head1;
                head1 = head1.next;
            }
            curr = curr.next;
        }

        curr.next = head1 == null ? head2 : head1;

        return newHead.next;
    }
}

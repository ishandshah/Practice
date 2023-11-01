/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.October.oct13;

import com.ishan.leetcode.linkedlist.Node;

public class LinkedListCycle {
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null)
            return false;
        Node curr = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            curr = curr.next;
            fast = fast.next.next;
            if (curr == fast)
                return true;
        }
        return false;
    }
}

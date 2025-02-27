/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.apple;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode next=null;
        ListNode prev=null;

        while(curr!=null){
            // First Store the next pointer to revers
            next=curr.next;
            // Point the prev pointer as curr.next
            // Basically change the direction
            curr.next=prev;
            // Update the previous values
            prev=curr;
            // Update the current value
            curr=next;


        }
        return prev;
    }
}

/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.apple;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;

        ListNode head1=list1;
        ListNode head2=list2;
        ListNode newHead=new ListNode(-1);
        ListNode curr = newHead;
        while(head1!=null && head2!=null){

            if(head1.val>=head2.val){
                curr.next=head2;
                head2=head2.next;
            }else{
                curr.next=head1;
                head1=head1.next;
            }
            curr=curr.next;
        }

        curr.next = head1 == null? head2:head1;

        return newHead.next;
    }
}

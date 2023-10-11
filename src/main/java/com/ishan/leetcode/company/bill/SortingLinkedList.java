/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.bill;

import com.ishan.leetcode.linkedlist.Node;

import static com.ishan.leetcode.linkedlist.Node.print;

// Sort 0's, 1's and 2's in a LinkedList
public class SortingLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);

        sort(head);
    }

    private static void sort(Node head) {


        int[] count={0,0,0};
        Node curre=head;


        while(curre!=null){

            count[curre.value]++;
            curre=curre.next;
        }
        curre=head;

        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                curre.value=i;
                count[i]--;
                curre=curre.next;
            }
        }
        print(head);
    }
}

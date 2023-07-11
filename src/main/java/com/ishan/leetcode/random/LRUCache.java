/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.random;


import java.util.HashMap;
import java.util.Map;

//The functions get and put must each run in O(1) average time complexity.
class LRUCache {
    // Hashtable backs up the Doubly Linked List for O(1) access to cache items
    Map<Integer, ListNode> hashtable = new HashMap<Integer, ListNode>();
    ListNode head;
    ListNode tail;

    int totalItemsInCache;
    int maxCapacity;
    private class ListNode {
        int key;
        int value;

        ListNode prev;
        ListNode next;
    }
    public LRUCache(int capacity) {
        maxCapacity=capacity;
        totalItemsInCache=0;
        head=new ListNode();
        tail=new ListNode();

        // Wire the head and tail together
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {

        if(hashtable.containsKey(key)){
            moveToHead(hashtable.get(key));
            return hashtable.get(key).value;
        }
        return -1;
        //
    }

    public void put(int key, int value) {
        ListNode node=hashtable.get(key);

        if(node==null){
            ListNode newNode=new ListNode();
            newNode.key=key;
            newNode.value=value;

            if(totalItemsInCache>=maxCapacity){
                removeLast();
            }
            totalItemsInCache++;
            hashtable.put(key,newNode);
            addToFront(newNode);
        }else{
            node.value=value;
            moveToHead(node);
        }
    }

    private void moveToHead(ListNode node) {
        removeFromList(node);
        addToFront(node);
    }

    private void removeFromList(ListNode node) {
        ListNode savedPrev = node.prev;
        ListNode savedNext = node.next;

        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;
    }

    // reduce the length
    private void removeLast() {
        ListNode tail = popTail();

        hashtable.remove(tail.key);
        --totalItemsInCache;

    }

    private ListNode popTail() {
        ListNode tailItem = tail.prev;
        removeFromList(tailItem);

        return tailItem;
    }

    private void addToFront(ListNode node) {

        node.prev = head;
        node.next = head.next;

    /*
      Re-wire the node after the head. Our node is still sitting "in the middle of nowhere".
      We got the new node pointing to the right things, but we need to fix up the original
      head & head's next.
      head <-> head.next <-> head.next.next <-> head.next.next.next <-> ...
      ^            ^
      |- new node -|
      That's where we are before these next 2 lines.
    */
        head.next.prev = node;
        head.next = node;
    }
}

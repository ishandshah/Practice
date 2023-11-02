/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.November.nov1;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
public class LRUCache {

    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>();
    }

    public void put(int key,int value){
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.val=value;
                map.put(key,node);
                moveToHead(node);
            }else{
                Node n1=new Node(key,value);
                if(map.size()>=capacity){
                    removeLast();
                    addToFront(n1);
                }else{

                    map.put(key,n1);
                    addToFront(n1);
                }
            }


    }

    private void removeLast() {
        Node tail = popTail();

        map.remove(tail.key);

    }

    private Node popTail() {
        Node tailed=tail.prev;
        removeNode(tailed);
        return tailed;
    }

    private void moveToHead(Node node) {
        removeFromList(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev=node;
        head.next=node;
    }

    private void removeFromList(Node node) {
        Node savedPrev = node.prev;
        Node savedNext = node.next;

        node.prev.next=savedNext;
        node.next.prev=savedPrev;
    }

    public int get(int key){
        if(map.containsKey(key)){
            moveToHead(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }

    private void removeNode(Node node) {
        Node savedPrev = node.prev;
        Node savedNext = node.next;

        node.prev.next=savedNext;
        node.next.prev=savedPrev;
    }

    class Node{

        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }

    }

}



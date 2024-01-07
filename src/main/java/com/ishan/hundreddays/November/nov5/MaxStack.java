package com.ishan.hundreddays.November.nov5;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class MaxStack {
    ListNode tail = null;
    ListNode head = null;
    TreeMap<Integer, List<ListNode>> cache = new TreeMap<>();

    public MaxStack() {
        tail = new ListNode(-1);
        head = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public void push(int x) {
        ListNode n = new ListNode(x);
        // add to Tree map
        cache.putIfAbsent(x, new ArrayList<>());
        cache.get(x).add(n);
        // -1-> 3 with 2 being new node
        // head = -1
        // head.next. prev = 2
        // n.next=head.next
        // head.next=2
        // n.pre = head
        head.next.prev = n;
        n.next = head.next;
        head.next = n;
        n.prev = head;
    }

    public int pop() {
        if (head.next == tail) {
            return -1;
        }
        // head = -1
        // curNode =2;
        // -1.next=3
        // 3.prev=-1
        ListNode curNode = head.next;
        head.next = head.next.next;
        head.next.prev = head;
        // remove the last occurrence from the list, if the list is empty, delete the value from the cache
        List<ListNode> curNodeList = cache.get(curNode.data);
        curNodeList.remove(curNodeList.size() - 1);
        if (curNodeList.size() == 0) {
            cache.remove(curNode.data);
        }
        return curNode.data;
    }

    public int top() {
        return head.next.data;
    }

    public int peekMax() {
        if (cache.size() == 0) {
            return -1;
        }
        return cache.lastKey();
    }

    public int popMax() {
        if (cache.size() == 0) {
            return -1;
        }
        // Get the cache.lastKey() and then remove the last occurence
        List<ListNode> maxNodes = cache.get(peekMax());
        ListNode maxNode = maxNodes.remove(maxNodes.size() - 1);
        if (maxNodes.size() == 0) {
            cache.remove(maxNode.data);
        }
        // 1-3-2
        // 3.next.prev=3.prev
        // 3.prev.next=3.next;
        maxNode.prev.next = maxNode.next;
        maxNode.next.prev = maxNode.prev;
        return maxNode.data;
    }

    class ListNode {
        ListNode prev;
        ListNode next;
        int data;

        ListNode(int data) {
            this.data = data;
        }
    }
}

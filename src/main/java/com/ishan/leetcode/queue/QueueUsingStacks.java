/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.queue;

import java.util.Iterator;
import java.util.Stack;

public class QueueUsingStacks {


    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueUsingStacks() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        //stack2.push(stack1.pop());
    }

    public int pop() {
        return stack2.pop();
    }

    public int peek() {

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
            return stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks myQueue = new QueueUsingStacks();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}

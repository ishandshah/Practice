/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd;

public class QueueUsingArray {

    private final int capacity;
    private int[] arr;
    private int front;
    private int rear;
    private int count;

    public QueueUsingArray(int size) {
        this.capacity = size;
        front = 0;
        rear = -1;
        count = 0;
        arr = new int[size];

    }

    public static void main(String[] args) {

        QueueUsingArray q = new QueueUsingArray(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Front element is: " + q.peek());
        q.dequeue();
        System.out.println("Front element is: " + q.peek());

        System.out.println("Queue size is " + q.size());

        q.dequeue();
        q.dequeue();

        if (q.isEmpty())
            System.out.println("Queue Is Empty");
        else
            System.out.println("Queue Is Not Empty");

    }

    public void dequeue() {
        if (count == 0) {
            System.out.println("Underflow");
            System.exit(1);
        }

        System.out.println("Removing " + arr[front]);
        front = (front + 1) % capacity;
        count--;
    }

    public void enqueue(int number) {
        if (count == capacity) {
            System.out.println("Overflow");
            System.exit(1);
        }


        rear = (rear + 1) % capacity;
        arr[rear] = number;
        count++;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("UnderFlow");
            throw new RuntimeException("Queue UnderFlow");
        }
        return arr[front];
    }

    public Boolean isEmpty() {
        return (size() == 0);
    }

    public Boolean isFull() {
        return (size() == capacity);
    }

    public int size() {
        return count;
    }

}

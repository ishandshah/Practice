/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.random;


import java.util.LinkedList;
import java.util.Queue;

/*
Design a hit counter which counts the number of hits received in the past 5 minutes.
Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing).
You may assume that the earliest timestamp starts at 1.
It is possible that several hits arrive roughly at the same time.
 */
public class HitCounter {

    //

    Queue<Integer> q;
    /** Initialize your data structure here. */
    private final int THIRTY_SECONDS = 10;
    public HitCounter() {
        q = new LinkedList<Integer>();
    }


    /** Record a hit.
     @param timestamp - The current timestamp  (in seconds granularity).
     */
    public void hit(int timestamp)
    {
        q.offer(timestamp);
    }    // Time Complexity : O(1)

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds
     granularity).
     */
    public int getHits(int timestamp)
    {
        // 10 - 0 >
        while (!q.isEmpty() && (timestamp - q.peek() >= THIRTY_SECONDS)) {
            q.poll();
        }
        System.out.println(q.size());
        return q.size();
    }
    // Time Complexity : O(n)
    public static void main(String[] args) throws InterruptedException {
        HitCounter obj = new HitCounter();
        for(int i=0;i<100000;i++)
            obj.hit(i);
        obj.getHits(0);
        Thread.sleep(150000); // 150
        obj.getHits(0);
    }
}



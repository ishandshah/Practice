/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd;

import java.util.ArrayDeque;
import java.util.Queue;

public class SlidingWindowRateLimiterRevision {

    // duration for a request before it can be evicted
    int duration;
    Queue<Long> times;

    // max requests in the queue
    int windowSize;

    public SlidingWindowRateLimiterRevision(int capacity, int windowDuration) {
        windowSize = capacity;
        this.times = new ArrayDeque<>(capacity);
        this.duration = windowDuration;
    }

    public static void main(String[] args) throws InterruptedException {

        SlidingWindowRateLimiterRevision sdr = new SlidingWindowRateLimiterRevision(3, 1121);
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                Thread.sleep(1221);
            }
            System.out.println(sdr.allowRequest() + " " + i);
        }
    }

    boolean allowRequest() {
        evictExpiredRequests();
        if (times.size() < windowSize) {
            times.offer(System.currentTimeMillis());
            return true;
        }
        return false;
    }

    private void evictExpiredRequests() {
        long currentTime = System.currentTimeMillis();
        while (!times.isEmpty() && currentTime - times.peek() > duration) {
            times.poll();
        }
    }
}

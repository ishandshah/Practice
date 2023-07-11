/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice.ratelimiter;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Queue;

public class SlidingWindowRateLimiter {
    private final int capacity;

    private final int rateLimit;
    // Time after which the requests can be thrown
    private final long windowSize;
    private final Queue<Long> requestTimes;

    public SlidingWindowRateLimiter(int capacity, int rateLimit, long windowSize) {
        this.capacity = capacity;
        this.rateLimit = rateLimit;
        this.windowSize = windowSize;
        this.requestTimes = new ArrayDeque<>(capacity);
    }

    public static void main(String[] args) {
        SlidingWindowRateLimiter sdr = new SlidingWindowRateLimiter(100, 1, 10);
        for (int i = 0; i < 100; i++) {
            System.out.println(sdr.allowRequest());
        }
    }

    public synchronized boolean allowRequest() {
        long currentTime = Instant.now().getEpochSecond();
        evictExpiredRequests(currentTime);

        if (requestTimes.size() < capacity) {
            requestTimes.offer(currentTime);
            return true;
        }

        long oldestRequestTime = requestTimes.peek();
        if (currentTime - oldestRequestTime >= windowSize) {
            requestTimes.poll();
            requestTimes.offer(currentTime);
            return true;
        }
        return false;
    }

    private void evictExpiredRequests(long currentTime) {
        while (!requestTimes.isEmpty() && currentTime - requestTimes.peek() >= windowSize) {
            requestTimes.poll();
        }
    }
}

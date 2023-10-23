/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.practiceatlassian.rateLimiterFactory;

import java.util.ArrayDeque;
import java.util.Queue;

public class SlidingWindowRateLimiter implements RateLimiter {

    private final long windowDuration = 3;
    private final Queue<Long> requestTimes;
    int windowSize;

    public SlidingWindowRateLimiter(int capacity) {
        windowSize = capacity;
        this.requestTimes = new ArrayDeque<>(capacity);
    }

    @Override
    public synchronized boolean allowRequest() {
        evictExpiredRequests();
        if (requestTimes.size() < windowSize) {
            requestTimes.offer(System.currentTimeMillis());
            return true;
        }

        //Still need to evict the oldest request
        // This logic doesn't do that but we should ideally remove the oldest and just add new
        long oldestRequestTime = requestTimes.peek();
        if (System.currentTimeMillis() - oldestRequestTime >= windowDuration) {
            requestTimes.poll();
            requestTimes.offer(System.currentTimeMillis());
            return true;
        }
        return false;
    }

    private void evictExpiredRequests() {
        long currentTime = System.currentTimeMillis();
        while (!requestTimes.isEmpty() && (currentTime - requestTimes.peek()) > windowDuration) {
            requestTimes.poll();
        }
    }
}

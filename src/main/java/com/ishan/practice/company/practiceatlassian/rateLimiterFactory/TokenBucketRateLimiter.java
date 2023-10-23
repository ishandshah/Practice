/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.practiceatlassian.rateLimiterFactory;

public class TokenBucketRateLimiter implements RateLimiter {

    int capacity;
    long lastServedRequest;

    int refillRate = 1;

    int tokensAvailable;

    public TokenBucketRateLimiter(int capacity) {
        this.capacity = capacity;
        lastServedRequest = System.currentTimeMillis();
        this.tokensAvailable = capacity;
    }

    @Override
    public boolean allowRequest() {
        refillTokens();

        if (tokensAvailable > 0) {
            tokensAvailable--;
            return true;
        }
        return false;
    }

    private void refillTokens() {
        long currentTime = System.currentTimeMillis();

        int refreshedTokens = ((int) (currentTime - lastServedRequest) * refillRate);
        tokensAvailable += refreshedTokens;
        tokensAvailable = Math.min(capacity, tokensAvailable);

        lastServedRequest = System.currentTimeMillis();
    }
}

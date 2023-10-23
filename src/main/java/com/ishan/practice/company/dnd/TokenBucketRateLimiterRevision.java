/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd;


// refill tokens at a given rate
public class TokenBucketRateLimiterRevision {


    int refillRatePerSecond = 1;

    // tokens currently available to be Served
    int tokensAvailable;

    // Timestamp used to refill accordingly
    long lastServedRequest;

    //max buckets that it can hold
    int capacity;


    public TokenBucketRateLimiterRevision(int capacity) {
        this.capacity = capacity;
        this.tokensAvailable = capacity;
        this.lastServedRequest = System.currentTimeMillis();
    }


    boolean allowToken() {

        refillTokens();
        if (tokensAvailable > 0) {
            tokensAvailable--;
            return true;
        }

        return false;
    }

    private void refillTokens() {
        long deltaInMs = lastServedRequest - System.currentTimeMillis();
        int delta = (int) (deltaInMs / 1000);
        int refill = delta * refillRatePerSecond;

        tokensAvailable += refill;

        tokensAvailable = Math.min(capacity, tokensAvailable);
        this.lastServedRequest = System.currentTimeMillis();

    }
}

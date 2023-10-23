/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.practiceatlassian.ratelimiter;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class TokenBucket {

    private final int capacity;
    private final int tokensPerSecond;
    private int tokens;
    private Instant lastRefillTime;

    public TokenBucket(int capacity, int tokensPerSecond) {
        this.capacity = capacity;
        this.tokensPerSecond = tokensPerSecond;
        this.tokens = capacity;
        this.lastRefillTime = Instant.now();
    }

    public static void main(String[] args) throws InterruptedException {
        // Create a token bucket with a capacity of 10 tokens and a rate of 2 tokens per second
        TokenBucket tokenBucket = new TokenBucket(10, 2);

        // Consume tokens
        for (int i = 0; i < 15; i++) {
            if (tokenBucket.consume(1)) {
                System.out.println("Token consumed");
            } else {
                System.out.println("Token not available");
            }

            // Sleep for 500 milliseconds
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

    public synchronized boolean consume(int tokensRequested) {
        refillTokens();

        if (tokens >= tokensRequested) {
            tokens -= tokensRequested;
            return true;
        } else {
            return false;
        }
    }

    private void refillTokens() {
        Instant now = Instant.now();
        long elapsedTime = now.toEpochMilli() - lastRefillTime.toEpochMilli();
        int tokensToAdd = (int) (elapsedTime * tokensPerSecond / 1000);

        if (tokensToAdd > 0) {
            tokens = Math.min(tokens + tokensToAdd, capacity);
            lastRefillTime = now;
        }
    }

}

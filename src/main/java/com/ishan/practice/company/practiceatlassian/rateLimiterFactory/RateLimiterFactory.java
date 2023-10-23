/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.practiceatlassian.rateLimiterFactory;


public class RateLimiterFactory {

    public RateLimiter createRateLimiter(RateLimiterAlgorithm algorithm, int capacity) {
        switch (algorithm) {
            case TOKEN_BUCKET:
                return new TokenBucketRateLimiter(capacity);
            case LEAKY_BUCKET:
                return new LeakyBucketRateLimiter(capacity);
            case SLIDING_WINDOW:
                return new SlidingWindowRateLimiter(capacity);
            default:
                throw new IllegalArgumentException("Unsupported rate limiter algorithm: " + algorithm);
        }
    }
}

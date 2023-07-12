/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.practiceatlassian.rateLimiterFactory;

public class RateLimiterExample {
    public static void main(String[] args) {
        RateLimiterFactory factory = new RateLimiterFactory();

        // Create a Token Bucket rate limiter
        RateLimiter tokenBucketRateLimiter = factory.createRateLimiter(RateLimiterAlgorithm.TOKEN_BUCKET, 10);
        boolean tokenBucketAllowed = tokenBucketRateLimiter.allowRequest();
        System.out.println("Token Bucket Rate Limiter Allowed: " + tokenBucketAllowed);

        // Create a Leaky Bucket rate limiter
        RateLimiter leakyBucketRateLimiter = factory.createRateLimiter(RateLimiterAlgorithm.LEAKY_BUCKET, 10);
        boolean leakyBucketAllowed = leakyBucketRateLimiter.allowRequest();
        System.out.println("Leaky Bucket Rate Limiter Allowed: " + leakyBucketAllowed);


        RateLimiter slidingWindow = factory.createRateLimiter(RateLimiterAlgorithm.SLIDING_WINDOW, 10);
        boolean slidingBucketAllowed = slidingWindow.allowRequest();
        System.out.println("Sliding Bucket Rate Limiter  Allowed: " + slidingBucketAllowed);
    }
}

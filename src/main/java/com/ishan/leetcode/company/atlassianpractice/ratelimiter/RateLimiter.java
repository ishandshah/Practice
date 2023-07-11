/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice.ratelimiter;


import java.time.Instant;

// Implement Rate limiter in Java
public class RateLimiter {

    private int capacity;
    private int tokens;
    private Instant lastRefillTime;
    //  private final int refillRate; // Tokens per second

    // static Map<String,Instant> clientRefreshMap=new HashMap<>();
    public RateLimiter(int capacity) {
        this.capacity = capacity;
        // this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = Instant.now();

    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(1000); // 10 tokens capacity, 5 tokens per millisecond refill rate
        Request client1 = new Request("clientId", 1, Instant.now());
        Request client2 = new Request("clientId2", 100, Instant.now());
        //    clientRefreshMap.put(client1.clientId,Instant.now());
        int client1Allowed = 0;
        int client1Denied = 0;
        int client2Allowed = 0;
        int client2Denied = 0;
        for (int i = 0; i < 1000000000; i++) {
            boolean allowed = rateLimiter.allowRequest(client1);
            if (allowed) {
                client1Allowed++;
                //System.out.println("Request client1 : " + (i + 1) + ": Allowed");
            } else {
                client1Denied++;
                System.out.println("Request client1 : " + (i + 1) + ": Denied");
            }
            boolean allowed2 = rateLimiter.allowRequest(client2);
            if (allowed2) {
                client2Allowed++;
                //System.out.println("Request client2 : " + (i + 1) + ": Allowed");
            } else {
                client2Denied++;
                System.out.println("Request client2 : " + (i + 1) + ": Denied");
            }
        }
        System.out.println("Allowed " + client1Allowed + " Denied " + client1Denied);
        System.out.println("Allowed 2 " + client2Allowed + " Denied 2 " + client2Denied);
    }

    public synchronized boolean allowRequest(Request client) {

        refillTokens(client);
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refillTokens(Request client) {

        //clientRefreshMap.putIfAbsent(client.clientId,Instant.now());
        Instant now = Instant.now();
        long timeElapsedSeconds = now.toEpochMilli() - client.lastRefillTime.toEpochMilli();
        int newTokens = (int) (timeElapsedSeconds * client.refillRate);
        tokens = Math.min(capacity, tokens + newTokens);
        client.lastRefillTime = Instant.now();
        //clientRefreshMap.put(client.clientId,Instant.now());
    }
}


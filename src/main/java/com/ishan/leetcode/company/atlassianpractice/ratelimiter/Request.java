/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice.ratelimiter;

import java.time.Instant;

public class Request {

        String clientId;
        int refillRate;

        Instant lastRefillTime;
    public Request(String clientId,int refillRate,Instant time) {
        this.clientId = clientId;
        this.refillRate=refillRate;
        this.lastRefillTime=time;
    }
//  int tokensUsed;


}

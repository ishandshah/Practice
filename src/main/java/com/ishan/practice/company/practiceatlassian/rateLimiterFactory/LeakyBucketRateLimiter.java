/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.practiceatlassian.rateLimiterFactory;

public class LeakyBucketRateLimiter implements RateLimiter {

    int capacity;

    int currentStorage;

    // no. of packets that enters the bucket at a time
    int input_pkt_size = 4;

    // no. of packets that exits the bucket at a time
    int output_pkt_size = 1;

    public LeakyBucketRateLimiter(int capacity) {
        this.capacity = capacity;
        currentStorage = 0;
    }

    @Override
    public boolean allowRequest() {

        int sizeLeft = capacity - currentStorage;

        if (sizeLeft < input_pkt_size) {
            System.out.println("package lost");
            return false;
        } else {
            currentStorage += input_pkt_size;

        }
        System.out.println("Buffer size= " + currentStorage
                + " out of bucket size= "
                + capacity);
        currentStorage -= output_pkt_size;
        return true;
    }
}

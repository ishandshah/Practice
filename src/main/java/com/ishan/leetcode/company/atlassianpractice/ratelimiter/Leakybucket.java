/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice.ratelimiter;

public class Leakybucket {


    public static void main(String[] args) {
        int no_of_queries, storage, output_pkt_size;
        int input_pkt_size, bucket_size, size_left;

        // initial packets in the bucket
        storage = 0;

        // total no. of times bucket content is checked
        no_of_queries = 4;

        // total no. of packets that can
        // be accommodated in the bucket
        bucket_size = 10;

        // no. of packets that enters the bucket at a time
        input_pkt_size = 4;

        // no. of packets that exits the bucket at a time
        output_pkt_size = 1;

        for (int i = 0; i < no_of_queries; i++) {
            size_left = bucket_size - storage; // space left

            if (input_pkt_size <= (size_left)) {
                storage += input_pkt_size;
            } else {
                System.out.println("Packet loss = "
                        + input_pkt_size);
            }
            System.out.println("Buffer size= " + storage
                    + " out of bucket size= "
                    + bucket_size);
            storage -= output_pkt_size;
        }
    }
}

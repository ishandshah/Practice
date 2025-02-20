/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.paypal;

import java.util.Arrays;

public class MaxSumRangeQuery {

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int Mod=1000000007;
        int n=nums.length;
        int[] freq=new int[n];

        for(int[] req:requests){
            int start=req[0];
            int end=req[1];

            freq[start]++;
            if(end + 1<n){
                freq[end+1]--;
            }

        }

        for(int i=1;i<n;i++){
            freq[i]+=freq[i-1];
        }


        Arrays.sort(freq);
        Arrays.sort(nums);
        long maxSum=0;

        for(int i=0;i<n;i++){
            maxSum = (maxSum + ((long) nums[i] * freq[i])) % Mod;

        }

        return (int) maxSum;
    }

    public static void main(String[] args) {
        //new MaxSumRangeQuery().maxSumRangeQuery();
    }
}

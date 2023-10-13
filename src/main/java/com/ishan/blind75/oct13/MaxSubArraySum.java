/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct13;

public class MaxSubArraySum {




    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));



    }

    public static int maxSubArray(int[] nums) {



        if(nums==null || nums.length<1)
            return 0;
        if(nums.length<2)
            return nums[0];
        int  maxSum=nums[0];
        int currentSum=nums[0];
        for(int i=1;i<nums.length;i++){
            currentSum=Math.max(currentSum + nums[i],nums[i]);
            maxSum=Math.max(currentSum,maxSum);
        }
        return maxSum;
    }
}

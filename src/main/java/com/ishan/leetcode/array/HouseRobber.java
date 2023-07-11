/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

public class HouseRobber {


    public static void main(String[] args) {
        int[] nums = {11, 12, 3, 1};
        System.out.println(findMaxProfit(nums));
    }

    private static int findMaxProfit(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for (int current : nums) {
            int max = Math.max(prev1, prev2 + current);
            prev2 = prev1;
            prev1 = max;

        }
        return prev1;
    }

}

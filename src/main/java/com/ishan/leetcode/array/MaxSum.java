/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

public class MaxSum {

    static int[] input = {-2, -3, -4, -1, -2, -1, -5, -3};

    public static void main(String[] args) {
        System.out.println("Maximum contiguous sum is "
                + maxSubArraySum(input));
    }


    // Function Call
    static int maxSubArraySum(int[] a) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here
                = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            // If the sum <0 then prev sum set to zero
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    public static int maxSubArray(int[] A) {
        //    static int[] input={-2, -3, -4, -1, -2, -1, -5, -3};
        int maxSoFar = A[0], maxEndingHere = A[0];

        for (int i = 1; i < A.length; ++i) {
            // -4
            // -2
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        Integer.toBinaryString(1);
        return maxSoFar;
    }

}

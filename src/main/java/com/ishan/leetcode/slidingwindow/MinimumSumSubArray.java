/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.slidingwindow;

public class MinimumSumSubArray {


    public static void main(String[] args) {
        int[] input = {10, 4, 2, 5, 6, 3, 8, 1};
        int k = 3;

        findMinimum(input, k);

    }

    private static void findMinimum(int[] input, int k) {
        int minSum = Integer.MAX_VALUE;
        int windowSum = 0;
        int start = 0;
        //{10, 4, 2, 5, 6, 3, 8, 1};
        for (int i = 0; i < input.length; i++) {
            windowSum += input[i];
            //16
            //
            if (i + 1 >= k) {
                if (minSum > windowSum) {
                    minSum = windowSum;
                    start = i + 2 - k;
                }
                windowSum += input[i + 1 - k];
            }


        }
        System.out.println(start + " start");
        System.out.println(start + k - 1 + " end");
    }
}

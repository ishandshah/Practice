/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.slidingwindow;


/* Given an array of positive integers,
find the smallest subarray’s length whose sum of elements is greater than a given number k.

Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 20
Output: The smallest sub-array length is 3
Explanation: The smallest sub-array with sum > 20 is {6, 7, 8}
 */
public class slidingWindowFindLength {


    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int sum = 20;

        findMinimum(input, sum);

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
            if (windowSum > k) {

                // minSum=Math.min(minSum,)

                windowSum += input[i + 1 - k];
            }


        }
        System.out.println(start + " start");
        System.out.println(start + k - 1 + " end");
    }
}



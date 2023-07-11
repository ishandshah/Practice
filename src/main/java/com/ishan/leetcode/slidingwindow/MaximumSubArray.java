/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.slidingwindow;

public class MaximumSubArray {


    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4, -5, -6, -7, -8, 0, -1, -19, -2};

        int k = 3;
        findMaxSubArray(arr, k);
    }

    private static void findMaxSubArray(int[] arr, int k) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;


        for (int i = 0; i < k; i++) {
            sum += arr[i];


        }

        maxSum = Math.max(sum, maxSum);

        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            maxSum = Math.max(sum, maxSum);
        }
        System.out.println("max sum is " + maxSum);
    }


}

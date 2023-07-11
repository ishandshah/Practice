/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

//https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/#
//Approach 4: Using Sliding Window with two pointer technique
public class RearrangeNegativePositive {
    public static void main(String[] args)
    {
        int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };

        rearrangePosNegWithOrder(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    // Here the size of window increases as it encounters
    // positive numbers
    private static void rearrangePosNegWithOrder(int[] arr) {
        int i = 0, j = 0;

        while (j < arr.length) {
            if (arr[j] >= 0) {
                j++;
            }
            // negative integer
            else{
                for (int k = j; k > i; k--) {
                    int temp = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = temp;
                }
                i++;
                j++;
            }
        }

    }
}

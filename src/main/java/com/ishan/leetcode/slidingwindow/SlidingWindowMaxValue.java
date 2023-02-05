/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.slidingwindow;

import java.util.ArrayDeque;

public class SlidingWindowMaxValue {


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int window = 3;
        System.out.println(findMaxSlidingWindow(array, window).length);

    }

    public static int[] findMaxSlidingWindow(int[] nums, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        // write yout code here
        int n = nums.length;
        int[] r = new int[n - windowSize + 1];
        int ri = 0;

        for (int i = 0; i < windowSize; i++) {

            // Remove older results
            while (!result.isEmpty() && result.peek() < i - windowSize + 1) {
                result.poll();
            }
            //Remove lesser than current values
            while (!result.isEmpty() && nums[result.peekLast()] < nums[i]) {
                result.pollLast();
            }
            result.offer(i);

            if (i >= windowSize - 1) {
                r[ri++] = nums[result.peek()];
            }

        }
        return r;
    }
}

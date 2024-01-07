/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.October.oct10;

import java.util.Arrays;

//https://leetcode.com/problems/sort-colors/
//TODO
public class SortColors {
    // doing it for 2 integers first
    public static void main(String[] args) {
        //sortTwoColors();

        sortThreeColors();
    }

    private static void sortThreeColors() {
        int[] nums = {0, 1, 1, 0, 2, 2, 1, 1, 0, 2, 1};


        int l = 0;
        int r = nums.length - 1;

        for (int i = 0; i <= r; )
            if (nums[i] == 0)
                swap(nums, i++, l++);
            else if (nums[i] == 1)
                i++;
            else
                swap(nums, i, r--);
        System.out.println(Arrays.toString(nums));


    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void sortTwoColors() {
        int[] nums = {0, 1, 1, 0};

        int j = nums.length - 1;
        int i = 0;
        for (int k = 0; k < nums.length; k++) {
            if (i != j) {
                if (nums[i] == 1 && nums[j] == 0) {
                    nums[i] = 0;
                    nums[j] = 1;
                    i++;
                    j--;
                } else if (nums[i] == 0) {
                    i++;
                } else if (nums[j] == 1) {
                    j--;
                }
            }

        }
        System.out.println(Arrays.toString(nums));
    }

}

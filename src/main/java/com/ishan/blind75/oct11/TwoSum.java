/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct11;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hasMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            hasMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {

            if (hasMap.containsKey(target - nums[i]) && i != hasMap.get(target - nums[i])) {

                return new int[]{i, hasMap.get(target - nums[i])};
            }
        }
        return null;
    }
}

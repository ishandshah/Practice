/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.meta.January;


import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 */
public class TwoSum {


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

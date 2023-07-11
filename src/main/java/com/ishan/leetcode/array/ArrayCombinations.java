/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayCombinations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> combinations = generateCombinations(nums);
        System.out.println(combinations);
    }

    private static List<List<Integer>> generateCombinations(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> combinations) {
        combinations.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, combinations);
            current.remove(current.size() - 1);

        }
    }
}

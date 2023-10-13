/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct13;

/* Cadent Interview question
 For a given target, find the starting index and ending index of that target
 Array is sorted but there can be multiple occurrences of the target value
 If range found, return it in [starting,ending] otherwise return [-1,-1]
 */
public class AdvancedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 4};
        int target = 1;
        int[] result = findRange(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    public static int[] findRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        // Find the first occurrence of the target value using binary search.
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result[0] = mid;
                right = mid - 1; // Continue searching in the left half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // If the target value was not found, return [-1, -1].
        if (result[0] == -1) {
            return result;
        }

        // Find the last occurrence of the target value using binary search.
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result[1] = mid;
                left = mid + 1; // Continue searching in the right half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
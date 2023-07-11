/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWORepeatingCharacters {


    public static void main(String[] args) {
        String input = "abcdeabfg";
        System.out.println(findLongestSubstring(input));
    }

    private static int findLongestSubstring(String input) {
        Set<Character> distinctSet = new HashSet<>();


        int left = 0, right = 0;

        int max = 0;

        while (right < input.length()) {

            if (distinctSet.contains(input.charAt(right))) {
                distinctSet.remove(input.charAt(left++));
            } else {
                distinctSet.add(input.charAt(right));
                right++;
                max = Math.max(max, right - left);
            }

        }

        return max;


    }
}

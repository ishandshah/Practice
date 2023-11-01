/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.October.oct17;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
/* Input: s = "abcabcbb"
Output: 3
*/
public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring lst = new LongestSubstring();

        Assert.assertEquals(3, lst.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(1, lst.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, lst.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(0, lst.lengthOfLongestSubstring(""));
        Assert.assertEquals(0, lst.lengthOfLongestSubstring(null));
    }

    public int lengthOfLongestSubstring(String input) {
        if (input == null)
            return 0;

        int left = 0, right = 0, length = input.length(), max = 0;
        Set<Character> distinctSet = new HashSet<>();


        while (right < length) {
            if (distinctSet.contains(input.charAt(right))) {
                distinctSet.remove(input.charAt(left++));
            } else {
                distinctSet.add(input.charAt(right++));
                max = Math.max(max, right - left);
            }
        }


        return max;
    }

}

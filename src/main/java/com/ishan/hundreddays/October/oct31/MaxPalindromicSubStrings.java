/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.October.oct31;

//https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings
public class MaxPalindromicSubStrings {
    public static void main(String[] args) {
        int abaczbzccc = new MaxPalindromicSubStrings().maxPalindromes("abaczbzccc", 3);
        System.out.println(abaczbzccc);
    }

    public int maxPalindromes(String s, int k) {

        if (s == null || s.length() < k) {
            return 0;
        }
        int ans = 0;
        int leng = s.length();
        for (int i = 0; i < leng; i++) {
            for (int j = i; j < leng; j++) {

                int len = (j - i) + 1;
                if (len > k + 1) break; // this is the key

                if (len >= k && isPalindrome(s, i, j)) {
                    ans++;
                    i = j;
                    break;
                }


            }

        }


        return ans;

    }

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.fiveweeks.week1dec10;

// https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {
    public static void main(String[] args) {
        int i = 121;
        System.out.println(isPalindrome(i));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int j = findReversed(x);
        return x == j;
    }

    private static int findReversed(int temp) {
        int number = 0;
        while (temp > 0) {
            int digit = temp % 10;
            number = number * 10 + digit;
            temp /= 10;
        }

        return number;
    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.October.oct29;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/break-a-palindrome/
public class BreakPalindrome {

    static boolean isPalindrome(String str) {

        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;

        // While there are characters to compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BreakPalindrome().breakPalindrome("abccba"));
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() < 2) {
            return "";
        }
        boolean checkFurther = Boolean.FALSE;
        List<String> palindromicStrings = new ArrayList<>();
        for (int i = 0; i < palindrome.length(); i++) {
            char c = palindrome.charAt(i);
            if (c - 'a' == 0) {
                c = (char) 98;
                if (i == 0) {
                    checkFurther = Boolean.TRUE;
                }
            } else {
                c = 'a';
            }
            String e = palindrome.substring(0, i) + c + palindrome.substring(i + 1);
            if (!isPalindrome(e)) {
                palindromicStrings.add(e);
                if (!checkFurther) {
                    break;
                }

            }
            System.out.println(palindromicStrings.size());
        }


        return palindromicStrings.stream().sorted().findFirst().get();
    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct12;

// One other way to do is to use ascii ranges instead of
// Character.isDigit || Character.isAlphabetic.
public class ValidPalindrome {
    public static void main(String[] args) {
        String in = "A man, a plan, a canal: Panama";
        isPalindromeFastest(in);
    }

    public static boolean isPalindromeFastest(String s) {
        if (s == null || s.length() < 2)
            return Boolean.TRUE;
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            Character c = s.charAt(i);
            Character d = s.charAt(j);
            if (!(Character.isDigit(c) || Character.isAlphabetic(c))) {
                i++;
            } else if (!(Character.isDigit(d) || Character.isAlphabetic(d))) {
                j--;

            } else if (c != d) {
                return false;
            } else {
                i++;
                j--;
            }

        }


        return true;
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return s.equals(sb.toString());
    }

    public boolean isPalindromeFaster(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        if (s == null || s.length() < 2)
            return Boolean.TRUE;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }

        }


        return true;
    }
}

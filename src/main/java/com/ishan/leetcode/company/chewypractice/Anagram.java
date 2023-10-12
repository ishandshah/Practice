/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.chewypractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {


    public static void main(String[] args) {
        String s1 = "ishan";
        String s2 = "nashi";

        System.out.println(isAnagram(s1, s2));

        System.out.println(isAnagram2(s1, s2));
    }

    private static boolean isAnagram2(String s1, String s2) {


        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map1.compute(c1, (k, v) ->
            {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });

            map2.compute(c2, (k, v) ->
            {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });

            if (map1.equals(map2)) {
                return true;
            }

        }
        return false;
    }

    public static boolean isAnagram(String s1, String s2) {
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars);

        return Arrays.equals(chars1, chars);


    }
}

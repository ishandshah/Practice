/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.slidingwindow;


//import static org.junit.Assert.assertEquals;

//import static junit.framework.Assert.assertEquals;

public class MinimumWindowSubsequence {


    public static void main(String[] args) {
        String s1 = "ishanx";
        String s2 = "xx";
        System.out.println(subsequence(s1, s2));

        //   assertEquals("shan",subsequence(s1,s2));
    }

    private static String subsequence(String s, String t) {

        int sIndex = 0;
        int tIndex = 0;
        int end = s.length() - 1;
        int start = 0;

        while (sIndex < s.length()) {

            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
            //n
            if (tIndex == t.length()) {
                int rightIndex = sIndex;
                tIndex--;
                while (tIndex >= 0) {
                    if (s.charAt(sIndex) == t.charAt(tIndex))
                        tIndex--;
                    sIndex--;
                }
                sIndex++;

                if (rightIndex - sIndex < end - start) {
                    start = sIndex;
                    end = rightIndex;
                }
                tIndex = 0;

            }

            sIndex++;
        }
        int windowSize = end - start + 1;
        if (windowSize == s.length())
            return "";
        else
            return s.substring(start, start + windowSize);
    }
}

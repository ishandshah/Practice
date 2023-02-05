/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.string;

public class LongestDistinctSubstring {

    public static void main(String[] args) {
        String test = "ABDEFGABEF";
        findLongestDistinctSubstring(test);
    }

    private static void findLongestDistinctSubstring(String test) {
        int res = 0;
        int n = test.length();
        for (int i = 0; i < n; i++) {


            boolean[] isVisited = new boolean[256];
            for (int j = i; j < n; j++) {

                if (isVisited[test.charAt(j)]) {
                    break;
                } else {

                    isVisited[test.charAt(j)] = true;
                    res = Math.max(res, j - i + 1);
                }


            }
        }

        System.out.println(res);

    }
}

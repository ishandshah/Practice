/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.paypal;


// https://leetcode.com/problems/smallest-greater-multiple-made-of-two-digits/description/?envType=company&envId=paypal&favoriteSlug=paypal-three-months
public class SmallestGreaterMultiple {


    public static void main(String[] args) {

    }

    // Main function to find the smallest multiple greater than n
    public static int findInteger(int k, int digit1, int digit2) {
        return findInteger(k,digit1,digit2,0l);
    }

    private static int findInteger(int k, int d1, int d2, long l) {

        if(l>Integer.MAX_VALUE)
                return -1;

        if(l>k && l%k==0)
            return (int)l;

        // Recursively try adding d1 and d2 as the next digit
        int x1 = (l + d1 == 0) ? -1 : findInteger(k, d1, d2, l * 10 + d1);
        int x2 = (l + d2 == 0) ? -1 : findInteger(k, d1, d2, l * 10 + d2);

        if (x1 > 1 && x2 > 1) {
            return Math.min(x1, x2);
        } else {
            return Math.max(x1, x2);
        }


    }


}

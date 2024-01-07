/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.fiveweeks.week1dec10;

//https://leetcode.com/problems/single-number/description/

// XOR of 2 same no's will result in 0
// XOR means if 2 digits same then 0 otherwise 1
public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 2, 1, 4};
        // XOR will result in 1,3,7,4,6,7,3
        int result = 0;
        for (int i : arr) {
            result = result ^ i;
            System.out.println("inp" + result);
        }
        System.out.println(result);
    }

}

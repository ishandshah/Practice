/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.fiveweeks.week1dec10;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes
public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 3, 0, 0};

        int position = 0;

        for (int x : arr) {
            if (x != 0) {
                arr[position++] = x;
            }
        }

        while (position < arr.length) {
            arr[position++] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }

}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        int[] a = {1, 2, 3};
        //3,2,1

        int[] b = {1, 1, 3};
        //2,1,1

        boolean[] booleanArray = new boolean[b.length];
        Arrays.sort(a);
        Arrays.sort(b);
        int j = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            while (j < b.length) {
                if (a[i] > b[j] && !booleanArray[j]) {

                    booleanArray[j] = true;
                    count++;
                    break;
                }

                j++;
            }

        }

        System.out.println("Hello world!" + count);
    }
}
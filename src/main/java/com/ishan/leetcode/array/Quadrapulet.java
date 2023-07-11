/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

import java.util.Arrays;

public class Quadrapulet {
    public static void main(String[] args) {
        int[] quadrapulet = findQuadruplet(new int[]{4, 1, 0, 1, 2, 2, 2, 3, 3, 0, 1}, 7);
        System.out.println(quadrapulet[0]);
        System.out.println(quadrapulet[1]);
        System.out.println(quadrapulet[2]);
        System.out.println(quadrapulet[3]);
    }

    public static int[] findQuadruplet(int[] arr, int s) {

        int n = arr.length;

        if (n < 4)
            return new int[]{};

        Arrays.sort(arr);

        for (int i = 0; i <= n - 4; i++) {

            for (int j = i + 1; j <= n - 3; j++) {
                int r = s - (arr[i] + arr[j]);

                // check for sum r in sub-array arr[j+1…n-1]
                int low = j + 1, high = n - 1;

                while (low < high) {
                    if (arr[low] + arr[high] < r)
                        low++;
                    else if (arr[low] + arr[high] > r)
                        high--;
                    else
                        return new int[]{arr[i], arr[j], arr[low], arr[high]};
                }
            }
        }
        return new int[]{};
    }
}

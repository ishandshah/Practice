/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ArrayDivisibleByK {

    public static void main(String[] args) {
        int[] A = {2, 2, 1, 7, 5, 3};
        int k = 4;
        int count = 0;
        Set<Integer> hash = new HashSet<>();
        for (int i : A) {
            hash.add(i);
        }

        for (int x : A) {
            if (hash.contains(x % k)) {
                System.out.println(x + "&& k" + x % k);
                hash.remove((x));
                count++;
            }
        }
        System.out.println(count);

    }
}

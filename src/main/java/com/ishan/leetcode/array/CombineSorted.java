/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

import java.util.LinkedHashSet;
import java.util.Set;

/*

Combine two sets of sorted ranges
into a unique set of non-overlapping ranges, returning an array of duplicates.
 */
public class CombineSorted {


    public static void main(String[] args) {
        int[] in1 = {1, 3, 5, 7, 8, 9};
        int[] in2 = {2, 4, 5, 6, 8, 9, 11, 13};

        Integer[] combine = new CombineSorted().combine(in1, in2);
        System.out.println(combine.length);

    }

    private Integer[] combine(int[] in1, int[] in2) {
        int len1 = in1.length;
        int len2 = in2.length;

        Set<Integer> output = new LinkedHashSet<>();
        Set<Integer> duplicate = new LinkedHashSet<>();
        //String[] arr = s.stream().toArray(String[] ::new);
        int index2 = 0, index1 = 0;
        while (len1 != 0 && len2 != 0) {
            if (len1 == 0) {
                while (len2 != 0) {

                    if (output.contains(in2[index2])) {
                        duplicate.add(in2[index2]);
                    } else {
                        output.add(in2[index2]);
                    }
                    len2--;
                    index2++;
                }

            }
            if (len2 == 0) {
                while (len1 != 0) {

                    if (output.contains(in1[index1])) {
                        duplicate.add(in1[index1]);
                    } else {
                        output.add(in1[index1]);
                    }
                    len1--;
                    index1++;
                }

            }


            if (in1[index1] == in2[index2]) {
                duplicate.add(in1[index1]);
                output.add(in1[index1]);
                index2++;
                index1++;
                len1--;
                len2--;
            } else if (in1[index1] < in2[index2]) {

                if (output.contains(in1[index1])) {
                    duplicate.add(in1[index1]);

                } else {
                    output.add(in1[index1]);
                }

                index1++;
                len1--;

            } else if (in1[index1] > in2[index2]) {
                if (output.contains(in2[index2])) {
                    duplicate.add(in2[index2]);

                } else {
                    output.add(in2[index2]);
                }

                index2++;
                len2--;
            }


        }


        return duplicate.stream().toArray(Integer[]::new);


    }
}

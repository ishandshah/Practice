/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SortArrayByOccurence {


    static Integer[] arr
            = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};

    // Driver Code
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(arr);

        // Function call
        sortBasedOnFrequencyAndValue(list);
    }

    // Compare Function
    public static void sortBasedOnFrequencyAndValue(List<Integer> list) {
        int n = arr.length;
        final HashMap<Integer, Integer> mapCount
                = new HashMap<>();
        final HashMap<Integer, Integer> mapIndex
                = new HashMap<>();
        int index = 0;
        for (Integer i : list) {

            if (mapCount.containsKey(i)) {
                mapCount.put(i, mapCount.get(i) + 1);
            } else {
                mapIndex.put(i, index);
                mapCount.put(i, 1);
            }
            index++;
        }


        Collections.sort(list, (n1, n2) -> {
            // 2, 8
            int freq1 = mapCount.get(n1);
            int freq2 = mapCount.get(n2);
            if (freq1 != freq2) {
                return freq2 - freq1;
            } else {
                return mapIndex.get(n1)
                        - mapIndex.get(
                        n2); // Elements with Lesser
                // Index gets Higher
                // Priority
            }
        });

        System.out.println(list);

    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.practiceatlassian;

import java.util.*;
import java.util.stream.Collectors;

public class SortBycount {
    static Map<Character, Integer> countMap = new HashMap<>();
    static Map<String, String> count = new TreeMap();

    public static void main(String[] args) {
        String text = "ishan shah is a sr engineer at Nordstrom";

        sortByCount(text);
    }

    private static void sortByCount(String text) {

        char[] input = text.toLowerCase().toCharArray();
        // count.put("ishan","shah");

        for (Character c : input) {

            countMap.compute(c, (k, v) -> {
                if (v != null) {
                    return v + 1;
                } else {
                    return 1;
                }
            });
        }

        List<Character> sorted = countMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                map(Map.Entry::getKey).collect(Collectors.toList());


        ;
    }


}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicates {


    public static void main(String[] args) {
        String testString="hi ishan hi Ishan";

        findDuplicates(testString);
    }

    private static void findDuplicates(String testString) {
        Set<String> checkSet=new HashSet<>();


        Arrays.stream(testString.split("\\s+")).
                map(String::toLowerCase).
                forEach(x->checkSet.contains(x));

        Arrays.stream(testString.split("\\s+")).
                map(String::toLowerCase).
                distinct().
                collect(Collectors.toList()).
                forEach(System.out::println);
    }
}

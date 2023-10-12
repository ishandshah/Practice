/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.bill;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find Resultant Array After Removing Anagrams
//https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
public class removeAnagrams {

    public static void main(String[] args) {

        String[] words = {"abba", "baba", "bbaa", "cd", "cd"};


        System.out.println(removeAnagramFaster(words));
    }

    private static List<String> removeAnagramFaster(String[] words) {
        Map<String, String> hashSet = new HashMap<>();
        for (String word : words) {


            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            hashSet.put(new String(chars), word);

        }

        return List.of(hashSet.values().toString());
    }


}

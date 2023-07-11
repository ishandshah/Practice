/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortBycount {
    public static void main(String[] args) {
        String text="ishan shah is a sr engineer at Nordstrom";

        sortByCount(text);
    }
    static Map<Character,Integer> countMap=new HashMap<>();
    static Map<String,String> count =new TreeMap();
    private static void sortByCount(String text) {

        char[] input=text.toLowerCase().toCharArray();
       // count.put("ishan","shah");

        for(Character c: input){

            countMap.compute(c, (k,v) -> {
                if(v != null) {
                    return v+1;
                } else {
                    return 1;
                }});
        }

        countMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

    }


}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static void main(String[] args) {
        String str = "abc";
        List<String> permutations = generatePermutations(str);
        System.out.println(permutations);
    }

    public static List<String> generatePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        backtrack(str.toCharArray(), 0, permutations);
        return permutations;
    }

    private static void backtrack(char[] toCharArray, int start, List<String> permutations) {
            if(toCharArray.length -1 == start){
                permutations.add(new String(toCharArray));
            }

            for(int i=start;i<toCharArray.length;i++){

                swap(toCharArray, start, i);
                backtrack(toCharArray,start+1,permutations);
                swap(toCharArray, start, i);
            }

    }

    private static void swap(char[] toCharArray, int start, int i) {

        char temp=toCharArray[start];
        toCharArray[start]=toCharArray[i];
        toCharArray[i]=temp;
    }
}

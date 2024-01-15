/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.jan14;


import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class LetterCombinationsofaPhoneNumber {

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        String[] combinations = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrackCombinations("", digits, combinations, output);
        return output;
    }

    private void backtrackCombinations(String combination, String next_digits, String[] phone_map, List<String> output) {
    if(next_digits.isEmpty()){
        output.add(combination);
    }else {
        String letters=phone_map[next_digits.charAt(0)-'0'];
        for(char letter:letters.toCharArray()){
            backtrackCombinations(combination+letter,next_digits.substring(1),phone_map,output);
        }
    }

    }
}
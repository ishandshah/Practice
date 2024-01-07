/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.November.nov14;

//https://leetcode.com/problems/integer-to-roman/

/*

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 */
public class IntegerToRoman {

    public String intToRoman(int num) {

        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] codes = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {

            while (num >= numbers[i]) {
                sb.append(codes[i]);
                num = num - numbers[i];
            }


        }

        return sb.toString();


    }
}

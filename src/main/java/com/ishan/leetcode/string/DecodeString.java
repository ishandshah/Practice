/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.string;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        DecodeString ds=new DecodeString();
        System.out.println(ds.decodeString("3[ab2[c]]"));
    }
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {

            // If & while character is digit, calcule the number and push it to Character Stack
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            // If start of braces, push the existing result to Result stack and reset result =""
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            // Main logic. if we consume ], Pop result stack's last result, then pop counter stack
            // and loop through count and append the current result to SB built using result stack's pop value
            else if (s.charAt(idx) == ']') {
                //abcc
                //""
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                // Just keep on appending the characters
                res += s.charAt(idx++);
            }
        }
        return res;
    }

}

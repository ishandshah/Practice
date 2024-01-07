/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.fiveweeks.week1dec10;

import java.util.Stack;

//https://leetcode.com/problems/backspace-string-compare/description/
public class BackSpaceStringCompare {


    public static void main(String[] args) {

        String s1 = "ab#c";
        String s2 = "ad#c";


        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Stack<Character> s1Stack = new Stack<>();
        Stack<Character> s2Stack = new Stack<>();
        for (char x : s1Arr) {
            if (x == '#') {
                if (!s1Stack.isEmpty()) {
                    s1Stack.pop();
                }
            } else {
                s1Stack.push(x);
            }
        }
        for (char y : s2Arr) {
            if (y == '#') {
                if (!s2Stack.isEmpty()) {
                    s2Stack.pop();
                }
            } else {
                s2Stack.push(y);
            }
        }


        System.out.println(s1Stack.equals(s2Stack));
    }

}

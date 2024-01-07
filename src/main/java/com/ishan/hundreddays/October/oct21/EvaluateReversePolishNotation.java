/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.October.oct21;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) throws Exception {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] input) throws Exception {
        String operators = "+-*/";
        Stack<String> stringStack = new Stack<>();
        for (String st : input) {
            if (!operators.contains(st)) {
                stringStack.push(st);
            } else {
                int a = Integer.valueOf(stringStack.pop());
                int b = Integer.valueOf(stringStack.pop());
                switch (st) {
                    case "+":
                        stringStack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stringStack.push(String.valueOf(a - b));
                        break;
                    case "*":
                        stringStack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stringStack.push(String.valueOf(a / b));
                        break;
                }
            }
        }
        return Integer.parseInt(stringStack.pop());
    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.October.oct13;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {


    public static void main(String[] args) {


        String input = "]";
        System.out.println(isValidParentheses(input));
    }

    private static boolean isValidParentheses(String input) {
        Map<Character, Character> parenthesesMap = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Stack<Character> characterStack = new Stack<>();
        char[] inputArray = input.toCharArray();

        for (Character c : inputArray) {
            if (parenthesesMap.containsKey(c) && !characterStack.isEmpty() && characterStack.peek().equals(parenthesesMap.get(c))) {
                characterStack.pop();
            } else {
                characterStack.push(c);
            }
        }

        return characterStack.isEmpty();
    }
}

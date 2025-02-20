/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.meta.January;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
public class ValidParentheses {

    // (){}[]
    public boolean isValid(String s) {
        Stack<Character> parenthesesStack=new Stack<>();
        Map<Character, Character> characterMap = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};


        for(int i=0;i<s.length();i++){
            char currentCh=s.charAt(i);

            if(!parenthesesStack.isEmpty() && characterMap.keySet().contains(currentCh) && characterMap.get(parenthesesStack.peek())==currentCh)
            {
                parenthesesStack.pop();
            }else{
                parenthesesStack.push(currentCh);
            }


        }

        return parenthesesStack.isEmpty();

    }

    public static void main(String[] args) {
        ValidParentheses vp=new ValidParentheses();
        System.out.println(vp.isValid("([)]"));
    }


}

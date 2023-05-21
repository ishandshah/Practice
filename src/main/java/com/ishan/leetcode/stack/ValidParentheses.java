/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {

        if(s==null){
            return true;
        }
        if(s.length() % 2!=0){
            return false;
        }
        Map<Character,Character> parenthesesMap=new HashMap<>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Stack<Character> characterStack=new Stack<>();


        char[] charArray=s.toCharArray();

        for(Character c:charArray){

            if(parenthesesMap.containsKey(c) && !characterStack.isEmpty() && characterStack.peek().equals(parenthesesMap.get(c))){
                characterStack.pop();
            }else{
                characterStack.push(c);
            }
        }

        return characterStack.isEmpty();
    }
    public static void main(String[] args) {
        String s="()";
        System.out.println(isValid(s));
    }
}

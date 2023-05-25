/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.stack;

import java.util.Stack;

public class evalReversePolishNotation {


    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
    public static String evalRPN(String[] input){


        String operators = "+-*/";
        Stack<String> characterStack=new Stack<>();

        for(int i=0;i<input.length;i++){
            String in=input[i];
            if(!operators.contains(in)){
                characterStack.push(in);
            }else{
                int a = Integer.valueOf(characterStack.pop());
                int b = Integer.valueOf(characterStack.pop());
                switch (in)
                {
                    case "+":
                        characterStack.push(String.valueOf(a + b));
                        break;
                    case "/":
                        characterStack.push(String.valueOf(a/b));
                        break;
                    case "-":
                        characterStack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        characterStack.push(String.valueOf(b * a));

                        break;
                }

            }



        }

        return characterStack.pop();
    }
}

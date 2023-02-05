/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.lamda;
//TODO pending run
public class LambdasAsArgumentsDemo {

    // This method has a functional interface as the type of
    // its first parameter. Thus, it can be passed a reference to
    // any instance of that interface, including the instance created
    // by a lambda expression.
    // The second parameter specifies the string to operate on.
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr="test";
        String outStr = stringOp((str) -> str.toUpperCase(), inStr);

        outStr = stringOp((str) -> {
            String result = "";
            int i;
            for(i = 0; i < str.length(); i++)
                if(str.charAt(i) != ' ')
                    result += str.charAt(i);
            return result;
        }, inStr);
        System.out.println("The string with spaces removed: " + outStr);
// Of course, it is also possible to pass a StringFunc instance
// created by an earlier lambda expression. For example,
// after this declaration executes, reverse refers to an
// instance of StringFunc.
        StringFunc reverse = (str) -> {
            String result = "";
            int i;
            for(i = str.length()-1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
// Now, reverse can be passed as the first parameter to stringOp()
// since it refers to a StringFunc object.
        System.out.println("The string reversed: " +
                stringOp(reverse, inStr));
    }
}
interface StringFunc {
    String func(String n);
}
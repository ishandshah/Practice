/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.lamda;

//todo RUN
//Read why interfaces cann't be PRIVATE
//TODO DEBUG STEP BY STEP
//TODO 398 PART I The Java Language

public class StaticMethodReference {

    static String strReverse(String str) {
        String result="";
        for(int i = str.length()-1; i >= 0; i--)
            result += str.charAt(i);
        return result;
    }

}

// A functional interface for string operations.
interface StringFunction {
    String func(String n);
}

class MethodRefDemo {



    // This method has a functional interface as the type of
// its first parameter. Thus, it can be passed any instance
// of that interface, including a method reference.
    static String stringOp(StringFunction sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambdas add power to Java";
        String outStr;
            // Here, a method reference to strReverse is passed to stringOp().
        outStr = stringOp(StaticMethodReference::strReverse, inStr);
        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
    }
}
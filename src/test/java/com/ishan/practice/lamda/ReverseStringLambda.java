/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.lamda;


interface ReverseString {

    String reverseString(String x);

}

//todo Run once Maven is fixed
public class ReverseStringLambda {


    public static void main(String[] args) {

        ReverseString reverseString = (x) -> {

            String result = "";
            int i;
            for (i = x.length() - 1; i >= 0; i--)
                result += x.charAt(i);

            return result;

            // return null;
        };
        String ishan = reverseString.reverseString("ishan");
        System.out.println(ishan);


    }
}
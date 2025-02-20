/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.recursion;
//TODO Tower of hanoi
public class RecursivePalindromeUsingSubstring {

    public static boolean recursivePalindromeUsingSubstring(String s){
        if(s.length()<=1)
            return true;
        else if (s.charAt(0)!=s.charAt(s.length()-1)){
            return false;
        }else
            return recursivePalindromeUsingSubstring(s.substring(1,s.length()-1));
    }

    public static boolean recursivePalindromeCheck(String s){
            return recursivePalindromeCheckHelper(s,0,s.length()-1);
    }

    private static boolean recursivePalindromeCheckHelper(String string, int i, int j) {

        if(j-i<=1){
            return true;
        }else if (string.charAt(i)!= string.charAt(j)){
            return false;
        }else{
            return recursivePalindromeCheckHelper(string,++i,--j);
        }
    }

    public static void main(String[] args) {
        System.out.println(recursivePalindromeCheck("abcdffdcba"));
    }


}

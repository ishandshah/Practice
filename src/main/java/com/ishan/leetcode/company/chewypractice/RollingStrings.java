/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.chewypractice;

//Expected Time Complexity: O(N).
//Expected Auxiliary Space: O(N).

//https://www.hackerrank.com/challenges/rotate-string/problem


//https://practice.geeksforgeeks.org/problems/roll-the-characters-of-a-string2127/1
public class RollingStrings {

    public static void main(String[] args) {

    String input="ishanzA";
    int[] roll={1,2,3,4,5,6};
        StringBuilder stringBuilder = null;
        for(int rol:roll){
            stringBuilder=new StringBuilder();
        for(int i=0;i<rol;i++){
                int ascii=input.charAt(i);
                if(ascii==122){
                    ascii=97;
                }else if(ascii==96){
                        // reset to A
                }else{
                    ascii++;
                }

          //  System.out.println(ascii);
            char c= (char) ascii;
            stringBuilder.append(c);
        }
            stringBuilder.append(input.substring(rol,input.length()-1));
            System.out.println(stringBuilder.toString());
    }

    }
}

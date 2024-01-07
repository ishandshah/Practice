/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.string;

import java.util.Arrays;

//https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {


    public static void main(String[] args) {
        String[] strs = {"flower","flow","floght"};
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length-1];
        int idx=0;

        while(idx<s1.length() && idx < s2.length()){

            if(s1.charAt(idx)==s2.charAt(idx)){
                idx++;
            }
            else{
                break;
            }
        }

        System.out.println(s1.substring(0,idx));

    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringSlidingWindow {


    public static void main(String[] args) {
        String test="ishandfshah";


        System.out.println(slidingWindowFindLen(test));
        
    }

    private static String slidingWindowFindLen(String input) {

        Set<Character> distinctSet=new LinkedHashSet<>();

       // if(input.length()<1)
           // return 0;

       // if(input.length()==1)
                //return 1;

        int left=0,right=0,max=0;
        String output="";

        while(right<input.length()){
                if(distinctSet.contains(input.charAt(right))){
                    distinctSet.remove(input.charAt(left++));
                }else{
                    distinctSet.add(input.charAt(right++));
                    if(max< right-left){
                        output=input.substring(left,right);
                    }
                    max=Math.max(max,right-left);
                    // Same
                    //max=Math.max(max,distinctSet.size());

                }

        }


        return output;
    }
}

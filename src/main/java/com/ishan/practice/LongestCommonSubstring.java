/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubstring {


    public static void main(String[] args) {

        String input1 = "abcabcbb";
        System.out.println(LongestCommonSubstring.fingLongestSubString(input1));
        System.out.println(fingLongestSubString("aaaaa") + " : 1");
        System.out.println(fingLongestSubString("abcacdef") + " : 5");
        System.out.println(fingLongestSubString("abcdab") + " : 4");
        System.out.println(fingLongestSubString("abcdef") + " : 6");
        System.out.println(fingLongestSubString("a") + " : 1");
        System.out.println(fingLongestSubString("interview") + " : 6");
        System.out.println(fingLongestSubString("abcababcdea") + " : 5");
        System.out.println("Active");

    }

    public static Integer fingLongestSubString(String inString) {

        if (inString == null || inString.length() == 0) {
            return 0;
        } else if (inString.length() == 1) {
            return 1;
        }


        int startIndex = 0;
        int endIndex = 0;
        int stringlength = inString.length();
        int maxLength = 0;

        Set<Character> characterSet = new HashSet<>();
        // 0 1.2 .
        //abcabc


        //abcacdef
        //i n t e r v i e w
        /**
         0, 5
         1, 6
         4,7
         4,8
         **/
        while (endIndex < stringlength) {
            //0 1 2 3 4 5 6 7
            //a b c c c d e f
            if (characterSet.contains(inString.charAt(endIndex))) {
                if (endIndex - startIndex > maxLength) {
                    maxLength = endIndex - startIndex;
                    System.out.println(inString.substring(startIndex, endIndex));
                }
                //  maxLength=Math.max(maxLength, endIndex-startIndex);
                characterSet.remove(inString.charAt(startIndex));
                startIndex++;
            } else {
                characterSet.add(inString.charAt(endIndex));
                endIndex++;

            }

            //  maxLength=Math.max(maxLength, endIndex-startIndex);
            if (endIndex - startIndex > maxLength) {
                maxLength = endIndex - startIndex;
                System.out.println(inString.substring(startIndex, endIndex));
            }
        }


        return maxLength;

    }

}


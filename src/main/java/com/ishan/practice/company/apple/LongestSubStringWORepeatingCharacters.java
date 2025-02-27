/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.apple;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWORepeatingCharacters {

    public int longestSubString(String s){

        int length=0;
        Set<Character> characterSet;
        characterSet = new HashSet<>();
        int i=0,j=0;
        int len=s.length();

        while(i<len && j<len){
            if(!characterSet.contains(s.charAt(j))){
                characterSet.add(s.charAt(j));
                j++;
                length=Math.max(length,j-i);
            }else{
                    characterSet.remove(s.charAt(i));
                    i++;
            }
        }



        return length;
    }
}

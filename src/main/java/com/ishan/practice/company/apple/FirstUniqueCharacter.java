/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.apple;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        int index=0;

        Map<Character,Integer> has=new HashMap<>();
        for(int i=0;i<s.length();i++){
            has.put(s.charAt(i), has.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i=0;i<s.length();i++){
            if(has.get(s.charAt(i))==1){
                return i;
            }
        }
return -1;
    }
}

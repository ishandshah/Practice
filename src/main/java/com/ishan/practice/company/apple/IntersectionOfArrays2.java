/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.apple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> freq=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        for(int i:nums1){
            freq.put(i,freq.getOrDefault(i,0) +1);
        }

        for(int i:nums2){
            if(freq.containsKey(i) && freq.get(i)>0){
                ans.add(i);
                freq.put(i, freq.get(i)-1);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}

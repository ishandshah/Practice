/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct10;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate/description/

// Other options;
// Sorting and then checking i to i-1
// Boolean array and maintain count
// double loop & compare each element with the other element
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
       Set<Integer> hashSet=new HashSet<>();
            for(int x: nums){
            if(hashSet.contains(x)){
                return true;
            }
            hashSet.add(x);
        }
        return false;
    }


}

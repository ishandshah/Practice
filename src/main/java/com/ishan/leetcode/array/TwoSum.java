/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //O(n2) Iterate both arrays and check sum
    public int[] twoSumBruteForce(int[] nums, int target)  {
        throw  new UnsupportedOperationException();
    }

    // O(NlogN) Sort and use 1 increment and decrementing pointer
    public int[] twoSumSort(int[] nums, int target) {
        Arrays.sort(nums);

        int i=0;
        int j=nums.length-1;

        while(i<j){
            if(nums[i] + nums[j] < target){
                i++;
            }else if(nums[i] + nums[j] > target){
                j--;
            }else{
                System.out.println("i = " + i + " j = " + j);
                return new int[]{i,j};
            }

        }

        return null;
    }


    //O(N) and o(N) check if the set contains the delta before adding the element to set

    public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> hasMap=new HashMap<>();
            for(int i=0;i<nums.length;i++){

                hasMap.put(nums[i],i);
            }

            for(int i=0;i<nums.length;i++){

                if(hasMap.containsKey(target-nums[i]) && i!=hasMap.get(target-nums[i])){

                    return new int[]{i,hasMap.get(target-nums[i])};
                }
            }
            return null;
        }

    public static void main(String[] args) throws Exception {
        int[] nums = {1,7,11,15};
        int target = 9;
        TwoSum tst=new TwoSum();
        tst.twoSumSort(nums,target);

    }
}

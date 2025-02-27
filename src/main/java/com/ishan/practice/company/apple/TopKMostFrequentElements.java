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

public class TopKMostFrequentElements
{
        public int subarraySum(int[] nums, int k) {
            int count =0;

            int[] sum=new int[nums.length+1];
            sum[0]=0;

            for(int i=1;i<=nums.length;i++){
                sum[i]= sum[i-1] + nums[i-1];
            }

            for(int start=0;start<sum.length;start++){
                for(int end=start+1;end<sum.length;end++){
                    if(sum[end]- sum[start] ==k){
                        count++;
                    }
                }
            }

            return count;
        }

       //Using hash map
        public int subArraysum2(int[] nums,int k) {

            int count=0;
            int sum=0;
            Map<Integer,Integer> hashMap=new HashMap<>();
            hashMap.put(0,1);

            for(int i=0;i<nums.length;i++){
             sum+=nums[i];

             if(hashMap.containsKey(sum-k)){
                 count+=hashMap.get(sum -k);
             }
             hashMap.put(sum,hashMap.getOrDefault(sum,0) + 1);

            }
            return count;
        }

}

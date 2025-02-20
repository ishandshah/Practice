/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.paypal;


import java.util.Arrays;

// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/?envType=company&envId=paypal&favoriteSlug=paypal-thirty-days&role=all
public class SmallestDivisor {

    public int smallestDivisor(int[] nums, int threshold) {

        Arrays.sort(nums);

        int largest=nums[nums.length-1];
        int smallest=1;
        int divisorSum;
        int mid;

        if(threshold==nums.length){
            return largest;
        }
        while(smallest<=largest){
            divisorSum=0;
            mid=(smallest + largest)/2;
            for(int x:nums){
                divisorSum += Math.ceil((double) x/ (double) mid);
            }

            if(divisorSum>threshold){
                smallest = mid + 1;
            }else{
                largest=mid-1;
            }

        }
        return smallest;
    }

    public static void main(String[] args) {
        SmallestDivisor sd=new SmallestDivisor();
        int i = sd.smallestDivisor(new int[]{21212,10101,12121}, 1000000);
        System.out.println(i);
    }


}

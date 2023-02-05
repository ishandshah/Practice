/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.slidingwindow;

public class MaxSubArrayLengthLessThanK {

 


    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,0,1,21,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0};

        int k=21;
        findMaxSubArrayLength(arr,k);
    }

    private static void findMaxSubArrayLength(int[] arr, int k) {


        int left=0;
        int right=0;
        int maxLength=0;
        int currentSum=0;
        while(right<arr.length){

            if(currentSum + arr[right] < k){
                currentSum+=arr[right];
                right++;
            }else{
                currentSum=currentSum-arr[left];
                maxLength=Math.max(maxLength, right-left);
                left++;
            }

        }
        maxLength=Math.max(maxLength, right-left);
        System.out.println(maxLength);
    }
}

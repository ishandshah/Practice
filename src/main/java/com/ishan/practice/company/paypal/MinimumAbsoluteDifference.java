/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/minimum-absolute-difference/description/?envType=company&envId=paypal&favoriteSlug=paypal-thirty-days
public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
    int[] arr = {4,2,1,3};
        minimumAbsDifference(arr);
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        Arrays.sort(arr);

        for(int i=1;i<arr.length;i++){

            if(arr[i] - arr[i-1] < min){
                min=arr[i] - arr[i-1];
            }
        }

        for(int i=1;i<arr.length;i++){

            if(arr[i] - arr[i-1] == min){
                result.add(List.of(arr[i-1],arr[i]));
            }
        }
        System.out.println(result);
        return result;
    }
}

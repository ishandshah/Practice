/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;

import java.util.Arrays;

public class NextGreaterElement {


    public static void main(String[] args) {
        System.out.println(new NextGreaterElement().nextGreaterElement(123));
        // 132
    }

    /// 534976
    // 536974
    // 536479
    
    // 2
        public int nextGreaterElement(int n) {
            char[] a = ("" + n).toCharArray();
            int i = a.length - 2;
            // Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit.
            while(i>=0 && a[i+1]<=a[i]){
                i--;
            }

            if(i<0){
                return -1;
            }
            int swap=Integer.MAX_VALUE;
            int j=i;
            int swapIndex=-1;
            // i = 2
            while(j<a.length){
                if(a[j]>a[i] && a[j]<swap){
                        swap=a[j];
                        swapIndex=j;
                }
                j++;

            }

            swap(a,i,swapIndex);

            Arrays.sort(a, i+1, a.length);

            long val = Long.parseLong(new String(a));
            return (val <= Integer.MAX_VALUE) ? (int) val : -1;



    }



    private void swap(char[] a, int i, int swapIndex) {

        char temp=a[i];
        a[i]=a[swapIndex];
        a[swapIndex]=temp;
    }

}

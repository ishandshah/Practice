/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.apple;

public class SortedSquares {

        public int[] sortedSquares(int[] A) {

            int left=0;
            int right=A.length-1;
            int x=A.length-1;
            int[] result = new int[A.length];

            while(x>=0){

                if(Math.abs(A[left]) < Math.abs(A[right])){
                    result[x]= A[right] * A[right];
                    right--;
                }else{
                    result[x]= A[left] * A[left];
                    left++;
                }

                x--;


            }
            return result;
        }



    }

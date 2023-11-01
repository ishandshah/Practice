/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.October.oct30;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix=
                {{1,2,3},{4,5,6},{7,8,9}};
        
        spiralPrint(matrix);

    }

    private static void spiralPrint(int[][] matrix) {

        int rows=matrix.length;
        int column=matrix[0].length;


        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> result = new ArrayList<>();

        while(left<=right && top<=bottom){

            if(top<=bottom){
    for(int i=left;i<right;i++){
        result.add(matrix[top][i]);
    }
            }
            top++;

            if(left<=right){
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
            }
            right--;

            if (top <= bottom) {
                for (int k = right; k >= left; k--) {
                    result.add(matrix[bottom][k]);
                }
            }
            bottom--;

            if (left <= right) {
                for (int l = bottom; l >= top; l--) {
                    result.add(matrix[l][left]);
                }
            }
            left++;
        }

       result.forEach(System.out::println);


    }
}

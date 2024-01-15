/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.jan7;

import java.util.Arrays;
//TODO DP
//https://leetcode.com/problems/01-matrix/description/
public class Matrix01 {

    public static void main(String[] args) {
        int[][] mat = {{0,1,1},{1,1,1},{1,1,1}};

        int[][] output=new int[mat.length][mat[0].length];
        int row=mat.length;
        int column=mat[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){


                if(mat[i][j]==0){
                    output[i][j]=0;
                    continue;
                }

                output[i][j] = row + column;

                if (i > 0) {
                    output[i][j] = Math.min(output[i][j], output[i - 1][j] + 1);
                }
                if (j > 0) {
                    output[i][j] = Math.min(output[i][j], output[i][j - 1] + 1);
                }

            }
            //System.out.println("I " + i + "   " + Arrays.deepToString(output));
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    continue;
                }
                if (i < row - 1) {
                    output[i][j] = Math.min(output[i][j], output[i + 1][j] + 1);
                }
                if (j < column - 1) {
                    output[i][j] = Math.min(output[i][j], output[i][j + 1] + 1);
                }
            }
        }

        System.out.println("I " + "   " + Arrays.deepToString(output));

    }
}

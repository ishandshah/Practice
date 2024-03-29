/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.October.oct15;

/*
 * https://leetcode.com/problems/01-matrix/
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 */

//todo fari
public class Matrix01 {
    public static void main(String[] args) {
        int[][] input = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] ints = zeroOne(input);


    }


    public static int[][] zeroOne(int[][] mat) {
        int[][] output = new int[mat.length][mat[0].length];
        int row = mat.length;
        int column = mat[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {


                if (mat[i][j] == 0) {
                    output[i][j] = 0;
                }
                if (i > 0) {
                    output[i][j] = Math.min(output[i][j], output[i - 1][j] + 1);
                }
                if (j > 0) {
                    output[i][j] = Math.min(output[i][j], output[i][j - 1] + 1);
                }

            }
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

        return output;

    }


}

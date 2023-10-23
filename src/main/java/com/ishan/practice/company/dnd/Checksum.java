/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd;

import java.util.Arrays;
import java.util.Random;

public class Checksum {

    // diff of largest and smallest value

    // 5 1 9 5
    //7 5 3
    //2 4 6 8

    // 3
    // 3
    //3
    public static void main(String[] args) {
        int[][] input = new int[2][4];
        int x = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                input[i][j] = new Random().nextInt(1, 10);
                x++;
            }
        }
        print2D(input);
        //   System.out.println(findCheckSum(input));

        System.out.println(findDivisibleCheckSum(input));
    }


    //todo enhance
    private static int findDivisibleCheckSum(int[][] input) {
        int sum = 0;
        boolean valueSet = false;
        for (int i = 0; i < input.length; i++) {

            for (int j = 0; j < input[0].length - 1; j++) {

                for (int k = j + 1; k < input[0].length; k++) {
                    if (input[i][j] % input[i][k] == 0 || input[i][k] % input[i][j] == 0) {
                        sum += (input[i][j] > input[i][k] ? input[i][j] / input[i][k] : input[i][k] / input[i][j]);
                        System.out.println("values" + input[i][k] + "_" + input[i][j]);
                        valueSet = true;
                        break;

                    }
                }
                if (valueSet) {
                    valueSet = false;
                    break;
                }
            }


        }


        return sum;
    }

    private static int findCheckSum(int[][] input) {

        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {

            for (int j = 0; j < input[0].length; j++) {

                if (input[i][j] < min_value) {
                    min_value = input[i][j];
                }
                if (input[i][j] > max_value) {
                    max_value = input[i][j];
                }

            }
            sum += max_value - min_value;
            min_value = Integer.MAX_VALUE;
            max_value = Integer.MIN_VALUE;
        }
        return sum;
    }

    public static void print2D(int mat[][]) {
        // Loop through all rows
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

}

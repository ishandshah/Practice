/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
/* const input = [1, 3, 0, 2, 3] // an array of integers between 0 - (n-1) -- 0,1,2,3,4

const output = [1, 1, 1, 2, 0] // output an array of same length,


and at each index, it counts how many times that index occured in the input.8?

 */
package com.ishan.leetcode.array;

import java.util.Arrays;

public class Splunk {

    public static void main(String[] args) {
        int[] input = {1, 3, 0, 2, 3};
        //

        int[] output = new int[input.length];

        for (int i : input) {
            //on occurrence, increment the index by 1
            output[i] += 1;
        }
        //O(1)
        int temp = -1;
        //temp =3;
        //0,index++,0,2,3
        //    1,3,0,2,3

        //-1,-1,-1,0,3
        for (int i = 0; i < input.length; i++) {
            int current = input[i];
            //1
            if (current < 0) {
                continue;
            }
            if (i == current) {
                //increment else skip ?
                input[i] = -1;
            } else {
                //3
                if (i < input[current]) {
                    temp = input[current];
                }
                input[current] = 0;
                input[current] -= 1;
                // [1] =-1

                // 1,1,0,2,3 -- 3
                // 0,-1,0,2,3
                // temp =3

                input[i] = 0;
                //System.out.println(Arrays.toString(input));
            }

        }

        if (temp != -1) {
            input[temp] -= 1;
        }


        System.out.println(Arrays.toString(input));

        System.out.println(Arrays.toString(output));
    }
}

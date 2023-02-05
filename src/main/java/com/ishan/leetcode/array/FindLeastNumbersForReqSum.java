/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

public class FindLeastNumbersForReqSum {

    public static void main(String[] args) {


        int[] input = {1, 2, 3, 4, 5, 10, 14};
        char[] in = {'b'};
        in[0] ^= 256;
        System.out.println("masking" + in[0]);
        int requiredSum = 25;

        int i = 0;
        int j = input.length - 1;
        int newJ = j, newI = i;
        int currentSum = 0;
        int count = 0;
        boolean varBoolean = true;
    }
//    while(varBoolean){
//
//        if(input[i] + input[j] !=currentSum){
//
//                if(newJ!=j) {
//                   currentSum += input[j];
//               }
//                else if(newI!=i){
//                   currentSum+=input[i];
//               }
//            if(currentSum<requiredSum){
//                newJ=j-1;
//            }else{
//                newI=i++;
//            }
//        }else{
//            varBoolean=false;
//        }
//
//    }
//        System.out.println("hi");
//    }

}

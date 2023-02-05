/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.TripActions;


import static java.lang.Math.pow;

/* Given a integer A (eg.555), and another int k (eg.1),
find unique number in A of length k that is divisible by A.


 */
public class DivisbleByK {

    public static void main(String[] args) {
        int a=555;
        int k=2;


        double i = pow(10, k-1);
        // int i=Integer.parseInt(String.valueOf(x));
        for(;i<a;i++){
            if(i>Math.pow(10,k)){
                break;
            }
            if(a % i==0){
                System.out.println("hello " + (int)i);
               break;
            }
        }

    }

}

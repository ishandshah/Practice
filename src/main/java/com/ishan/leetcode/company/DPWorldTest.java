/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company;


// sqrt - 3

// 10.79



/* Given arrival and departure times of all trains that reach a railway station,
the task is to find the minimum number of platforms required for the railway station so that no train waits. */

/*
Input:
        arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
        dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
        boolean[] isAvailable={x,x,x,x,x,x}
        1,1,1,1,0,0
        */
public class DPWorldTest {


    static int[] arr = {900, 940, 950, 1100, 1500, 1800};
    static int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

//
//    for(int i=0;i<arr.)

    public static void main(String[] args) {
        System.out.println(getNumberOfPlatforms(arr, dep));

        findSqrt();
    }

    private static void findSqrt() {

        // 3 3.25
        double number = 10.79;

        double squaredValue = Math.floor(number);
        double ceilingValue = Math.ceil(number);
        double smallerRange = 0;
        double largerRange = 0;
        double x = 0.0;
        while (x < ceilingValue) {
            smallerRange = x;
            x++;
            largerRange = x;
            x = Math.pow(x, x);
        }

        System.out.println(smallerRange);
        System.out.println(largerRange);

// 0.01
    }

    private static int getNumberOfPlatforms(int[] arr, int[] dep) {

        int numberOfPlatforms = 0;
        boolean[] isAvailable = new boolean[arr.length];


        if (arr == null || arr.length == 0) {
            return 0;
        }
        numberOfPlatforms++;
        isAvailable[0] = true;
                   /*
         static int arr[] = {900, 940, 950, 1100, 1500, 1800};
         static int dep[]=  {910, 1200, 1120, 1130, 1900, 2000};
         */
        boolean foundPlatform = false;
        for (int i = 1; i < arr.length; i++) {
            foundPlatform = false;
            for (int j = 0; j < i; j++) {

                if (arr[i] > dep[j] && isAvailable[j]) {
                    isAvailable[j] = false;
                    foundPlatform = true;
                    break;
                }
                isAvailable[i] = true;
            }
            if (!foundPlatform) {
                numberOfPlatforms++;
            }

        }
        return numberOfPlatforms;
    }
}

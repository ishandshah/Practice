/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.paypal;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;

//https://www.youtube.com/watch?v=OBOrT0bBbqo
public class MinimumScheduler {


    public static void main(String[] args) {
        int[][] slots1 = new int[][]{{10,50},{60,120},{140,210}};
        int[][] slots2 = {{10,15}, {60,70}};
        int duration = 8;

        var schedule = schedule(slots1, slots2, duration);
        System.out.println("Start" + schedule.get(0));
        System.out.println("END" + schedule.get(1));
    }

    private static List<Integer> schedule(int[][] slots1, int[][] slots2, int duration) {
                int i=0;
                int j=0;
                int n1= slots1.length;;
                int m2=slots2.length;
                    int start=-1;
                    int end=-1;
                Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
                Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));


                while(i<n1 && j<m2){
                    start=Math.max(slots1[i][0],slots2[j][0]);
                    end=Math.min(slots1[i][1],slots2[j][1]);


                    if(end- start>=duration){

                        return List.of(start
                        ,start+duration);
                    }else if(slots1[i][0]<slots2[j][0]){
                        i++;
                    }else {
                        j++;
                    }


                }


            return EMPTY_LIST;
    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.November.nov3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// todo
//https://leetcode.com/problems/random-pick-with-weight/
public class WeightedRandomPick {
    public static void main(String[] args) {


        int[] array= {1,3,5};
        // 1, 4 ,9

        // 9
        // 0 to 9
        //findRandomWeightedEasy(array);
        for(int i=0;i<9;i++)
            find(array);
    }

    private static void find(int[] array) {
            int[] sum=new int[array.length];
            int i=0;
            int sumT=0;

            for(int x:array){
                sum[i] = sumT+x;
                sumT = sumT + x;
                i++;
            }
           // sumT=sum[sum.length -1];
            int pickIndex2=pickIndex2(sumT);


            for(int j=0;j<sum.length;j++){
                if(sum[j] >=pickIndex2){
                    System.out.println("found " + j);
                    break;
                }
            }

    }

    public static int pickIndex2(int sum) {
        Integer i=new Random().nextInt(0,sum);
        System.out.println("picked index" + i);
        return i;
    }

    Random rand;
    public static List<Integer> nums=new ArrayList<>();

    public static void findRandomWeightedEasy(int[] w) {

        Random rand = new Random();

            for (int i = 0; i < w.length; i++)
                for (int j = 0; j < w[i]; j++)
                    nums.add(i);
        }

        public int pickIndex() {
            int n = this.rand.nextInt(nums.size());
            return nums.get(n);
        }



    }

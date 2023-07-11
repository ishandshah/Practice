/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

import java.util.ArrayList;
import java.util.List;

//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]

// [1,5] [6,9]
//todo update
public class InsertIntervals {


    public static List<List<Integer>> mergeIntervals(int[][] actual, int[] merge){
        List<List<Integer>> outputList=new ArrayList<>();

        int begin=merge[0];
        int end=merge[1];
        boolean add=true;

        // 1, 3 6,9
        // 2,5
        int holdStart=Integer.MAX_VALUE;
        int holdend=Integer.MIN_VALUE;

        for(int[] actualArray:actual){

                if(begin> actualArray[0] && begin <= actualArray[1] && end >=actualArray[1]) {

                    holdStart=Math.min(holdStart,actualArray[0]);
                    holdend=Math.max(holdend,actualArray[1]);
                    add=false;
                }
                 if(!add && actualArray[0] > end){
                    //add

                    if(!add){

                        List temp=new ArrayList<>();
                        ArrayList<Integer> objects = new ArrayList<>();
                        objects.add(holdStart);
                        objects.add(holdend);
                        outputList.add(objects);
                    }

                    holdStart=actualArray[0];
                    holdend=actualArray[1];
                    add=true;
                }else{
                    holdStart=Math.min(holdStart,actualArray[0]);
                    holdend=Math.max(holdend,actualArray[1]);
                    continue;
                }


                if(add){

                    List temp=new ArrayList<>();
                    ArrayList<Integer> objects = new ArrayList<>();
                    objects.add(holdStart);
                    objects.add(holdend);
                    outputList.add(objects);
                }


        }


            return outputList;

    }
    public static void main(String[] args) {
            int[][] input={{1,2},{3,5},{6,7},{8,10},{12,16}};

            // {{[[}}1,2},{3,5},{[}6,7},{8,10},{12,16}}
            int[] merge={4,8};

        List<List<Integer>> listList = mergeIntervals(input, merge);


        for (List<Integer> integers : listList) {
            System.out.println("pair" + integers.get(0) + "su " + integers.get(1));
        }

    }
}

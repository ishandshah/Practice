/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;


import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

//https://leetcode.com/problems/most-profit-assigning-work/description/
public class ProfitAssigningWork {


    public static void main(String[] args) {
        int [] difficulty = {2,4,6,8,10}, profit = {10,20,30,40,50}, worker = {4,5,6,7};
        
        findMaxProfit(difficulty,profit,worker);
    }


    // It works but TLE for really large inputs
    private static void findMaxProfit(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer,Integer> integerIntegerMap=new HashMap<>();
        for(int i=0;i< profit.length;i++){
            integerIntegerMap.put(i,profit[i]);
        }

        integerIntegerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue());
        int profitSoFar=0,maxprofit=0;
        for(int work:worker){

            for(Map.Entry<Integer,Integer> entry:integerIntegerMap.entrySet()){
                outerloop:
                if(difficulty[entry.getKey()] <= work){
                    profitSoFar=Math.max(entry.getValue(),profitSoFar);
                    break outerloop;
                }
            }

            maxprofit+=profitSoFar;
            profitSoFar=0;
        }

        System.out.println(maxprofit);
    }


    // Create an array and sort by difficult and then keep on finding profit as far as worker skill > difficulty
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Point[] jobs = new Point[n];
        for (int i = 0; i < n; i++)
            jobs[i] = new Point(difficulty[i], profit[i]);
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.x));

       // This is amazing, if a worker less skilled than next worker
        // makes 10$ than the next worker is obviously gonna make 10$
        //& that's why the i in the equation is never reset and best too
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
        for (int skill: worker) {
            while (i < n && skill >= jobs[i].x)
                best = Math.max(best, jobs[i++].y);
            ans += best;
        }

        return ans;
    }
}

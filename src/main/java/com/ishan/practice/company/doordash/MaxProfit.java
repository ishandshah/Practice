/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MaxProfit {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        // Sort the array to process by sorted end time to know the max profit so far
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        // The TreeMap dp is used to efficiently store and
        // retrieve the maximum profit obtained by scheduling jobs up to a particular end time.
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        // Before starting a job our profit so far is zero
        dp.put(0, 0);
        for (int[] job : jobs) {
            // Profit so far before starting this job
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            // If profit so far is greater than previous profits, add to map by end time
            if (cur > dp.lastEntry().getValue())
                dp.put(job[1], cur);
        }
        // get the value with the max profit so far
        return dp.lastEntry().getValue();
    }

    public static void main(String[] args) {
        int[] startTime = {1,2,3,3}, endTime = {3,4,5,6}, profit = {50,10,40,70};
        System.out.println(new MaxProfit().jobScheduling(startTime,endTime,profit));
    }
}

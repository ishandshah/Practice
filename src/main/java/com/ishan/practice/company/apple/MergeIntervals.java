/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;

        List<List<Integer>> mergedIntervals = new ArrayList<>();
        int s = intervals[0][0], e = intervals[0][1];

        for(int i=1;i<n;i++){
            if(intervals[i][0]<=e){
                e = Math.max(e, intervals[i][1]);

            }else{
                mergedIntervals.add(Arrays.asList(s,e));
                s = intervals[i][0];
                e = intervals[i][1];;
            }




        }

        mergedIntervals.add(Arrays.asList(s,e));
        int[][] ans = new int[mergedIntervals.size()][2];
        for(int i=0;i<mergedIntervals.size();i++){
            ans[i][0] = mergedIntervals.get(i).get(0);
            ans[i][1] = mergedIntervals.get(i).get(1);
        }

        return ans;


    }
}

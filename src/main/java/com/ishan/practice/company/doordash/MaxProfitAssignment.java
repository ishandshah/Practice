/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;

import com.ishan.practice.tuple.TwoTuple;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class MaxProfitAssignment {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Pair[] pairs=new Pair[difficulty.length];
        for (int i = 0; i < pairs.length; i++)
            pairs[i] = new Pair(difficulty[i], profit[i]);
         // Sorted by increasing difficulty
        Arrays.sort(pairs, Comparator.comparingInt(obj->obj.x));

        int n=difficulty.length;
        Arrays.sort(worker);
        int i=0;
        int ans=0;
        int best=0;
        for(int work:worker){
            while (i < n && work >= pairs[i].x)
                ans = Math.max(ans, pairs[i++].y);
            best += ans;
        }

        return best;
    }

    private class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    }

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.random;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {

    public static void main(String[] args)
    {

        ItemValue[] arr = { new ItemValue(60, 10),
                new ItemValue(100, 20),
                new ItemValue(120, 32) };

        int capacity = 50;

        double maxValue = getMaxValue(arr, capacity);

        // Function call
        System.out.println(maxValue);
    }

    private static double getMaxValue(ItemValue[] arr, int capacity) {

        // Sorting items by profit/weight ratio;

        Arrays.sort(arr, new Comparator<ItemValue>() {

            @Override
            public int compare(ItemValue o1, ItemValue o2) {

                double cpr1=(double)o1.profit/(double)o1.weight;
                double cpr2=o2.profit/o2.weight;
                if (cpr1 < cpr2)
                    return 1;
                else
                    return -1;
            }
        });
        double totalValue = 0d;
        for (ItemValue i : arr) {

            int curWt = (int)i.weight;
            int curVal = (int)i.profit;

            if (capacity - curWt >= 0) {

                // This weight can be picked whole
                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {

                // Item cant be picked whole
                double fraction
                        = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
         /*      // capacity
                        = (int)(capacity - (curWt * fraction));*/
                break;
            }
        }

        return totalValue;
    }

    // Item value class
    static class ItemValue {

        int profit, weight;

        // Item value function
        public ItemValue(int val, int wt)
        {
            this.weight = wt;
            this.profit = val;
        }
    }

}

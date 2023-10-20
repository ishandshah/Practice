/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct14;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuy {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0, profit = 0;
        //11
        int initialValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > initialValue) {
                profit = Math.max(profit, prices[i] - initialValue);
                maxProfit = Math.max(profit, maxProfit);

            } else {
                initialValue = prices[i];
            }

        }
        return maxProfit;
    }
}

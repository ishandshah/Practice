/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.October.oct31;

//https://leetcode.com/problems/maximum-profit-from-trading-stocks/

/*

For each new stock, we can either buy or not buy, so for each budget, we check if we can buy or not buy.

This means that the outer for loop is the stock with the inner loop being the budget.
We will only buy a stock when doing so makes a profit.

Let dp[i][j] be the maximum profit that can be made with budget j and 0 ~ ith stock.
Then, we have dp[i][j] = max( dp[i-1] [j - present[i]] + future[i] - present[i], dp[i-1][j])

This dp only depends on the previous row, hence we have no need for 2D dp, let's write it in 1D && since j - present[i] is only ever smaller than j, we can loop it backward to get rid of the need to create a tmp 1D array.


Time Complexity: O(budget * len of stock)
Space Complexity: O(budget)
 */
public class MaximumProfit {
    public static int maximumProfit(int[] present, int[] future, int budget) {
        int[] dp = new int[budget+1];
        for (int i = 0; i < present.length; i++){
            for (int j = budget; j >= 0; j--){
                if (j >= present[i]){
                    if(present[i] > future[i]){
                        break;
                    }else{
                        dp[j] = Math.max(dp[j], dp[j - present[i]] + future[i] - present[i]);
                    }
                }
            }
        }
        return dp[budget];

    }

    public static void main(String[] args) {
        int[] present = {5,4,6,2,3}, future = {8,5,4,3,5};
         int budget = 10;
        System.out.println(maximumProfit(present,future,budget));
    }

}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {


    public static void main(String[] args) {
        int[] coins = {1, 5, 6};
        int amount = 11;
        System.out.println(new CoinChange().minimumCoinTopDown(amount, coins, new HashMap<>()));
    }


    public int coinChange(int[] coins, int amount) {
        //12
        int max = amount + 1;
        // array of size : 12
        int[] dp = new int[amount + 1];
        // Fill arrays with value 12
        Arrays.fill(dp, max);
        // defaulting first value to zero
        dp[0] = 0;
        // 1 to <==1
        for (int i = 1; i <= amount; i++) {
            // j = 1,5,6
            for (int j = 0; j < coins.length; j++) {
                //
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * Top down dynamic programing. Using map to store intermediate results.
     * Returns Integer.MAX_VALUE if total cannot be formed with given coins
     */
    public int minimumCoinTopDown(int total, int[] coins, Map<Integer, Integer> map) {

        //if total is 0 then there is nothing to do. return 0.
        if (total == 0) {
            return 0;
        }

        //if map contains the result means we calculated it before. Lets return that value.
        if (map.containsKey(total)) {
            return map.get(total);
        }

        //iterate through all coins and see which one gives best result.
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            //if value of coin is greater than total we are looking for just continue.
            if (coins[i] > total) {
                continue;
            }
            //recurse with total - coins[i] as new total
            int val = minimumCoinTopDown(total - coins[i], coins, map);

            //if val we get from picking coins[i] as first coin for current total is less
            // than value found so far make it minimum.
            if (val < min) {
                min = val;
            }
        }

        //if min is MAX_VAL don't change it. Just result it as is. Otherwise add 1 to it.
        min = (min == Integer.MAX_VALUE ? min : min + 1);

        //memoize the minimum for current total.
        map.put(total, min);
        return min;
    }
}

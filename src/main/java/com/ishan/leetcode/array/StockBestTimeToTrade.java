/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

public class StockBestTimeToTrade {

    public int maxProfitSingleTransaction(int[] prices) {

        if(prices==null || prices.length<2){
            return 0;
        }
        int maxProfit=0,profit=0;
        //11
        int initialValue=prices[0];
        for(int i=1;i<prices.length;i++){
                if(prices[i] > initialValue){
                    profit=Math.max(profit,prices[i]-initialValue);
                    maxProfit=Math.max(profit,maxProfit);

                }else{
                    initialValue=prices[i];
                }

        }
        return maxProfit;
    }


    private int maxProfitMultipleTransaction(int[] prices) {

        if(prices==null || prices.length<2){
            return 0;
        }
        int maxProfit=0,profit=0,profitSoFar=0;
        //11
        int initialValue=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i] > initialValue){
                profit=Math.max(profit,prices[i]-initialValue);
                maxProfit=Math.max(profit,maxProfit);
                profitSoFar=Math.max(profitSoFar,maxProfit);

            }else{
                initialValue=prices[i];
            }

        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices={11,1,2,3,4,9,6,7,2,11};
        StockBestTimeToTrade sts=new StockBestTimeToTrade();
        System.out.println(sts.maxProfitSingleTransaction(prices));


        System.out.println(sts.maxProfitMultipleTransaction(prices));
    }


}

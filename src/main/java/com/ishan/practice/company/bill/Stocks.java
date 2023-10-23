/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.bill;

//Stocks sliding window data structures question
public class Stocks {


    public static void main(String[] args) {
        int[] stocks = {111, 411, 1, 15, 12, 11, 1, 18};

        System.out.println(findProfit(stocks));
    }

    private static int findProfit(int[] stocks) {

        int max = 0, currentMax = 0;

        int value = stocks[0];
        for (int i = 1; i < stocks.length; i++) {
            if (stocks[i] > value) {
                currentMax = stocks[i] - value;
                max = Math.max(max, currentMax);
            } else {
                value = stocks[i];
            }


        }
        System.out.println(max);
        return max;

    }
}

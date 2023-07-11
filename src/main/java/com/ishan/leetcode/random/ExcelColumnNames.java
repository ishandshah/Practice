/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.random;

public class ExcelColumnNames {
    public static void printExcelColumnNames(int n) {
        StringBuilder columnName = new StringBuilder();

        while (n > 0) {
            int remainder = (n - 1) % 26; // Calculate the remainder
            char ch = (char) ('A' + remainder); // Convert the remainder to a character
           // columnName.insert(0, ch); // Insert the character at the beginning of the string
            columnName.append(ch);
            n = (n - 1) / 26; // Update the value of n
        }

        System.out.println("Excel Column Name: " + columnName.reverse());
    }

    public static void main(String[] args) {
        int column1 = 1;
        int column2 = 28;
        int column3 = 7011;

        printExcelColumnNames(column1);
        printExcelColumnNames(column2);
        printExcelColumnNames(column3);
    }
}
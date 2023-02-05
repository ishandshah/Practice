/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

public class IslandAbstraction {

    public static int numIslands(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    count++;
                    shrink(grid, i, j);
                }
            }
        }
        return count;
    }

    static void shrink(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        shrink(grid, i, j + 1);
        shrink(grid, i, j - 1);
        shrink(grid, i + 1, j);
        shrink(grid, i - 1, j);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {0, 1, 1, 1}};

        System.out.println(numIslands(grid));
    }
}

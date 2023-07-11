/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Random;

//Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
public class ZeroOneMatrix {

    static int[][] directions={ {-1,0} ,{0,1},{1,0},{0,-1}};
    public static int[][] updateMatrix(int[][] mat) {
        int[][] res= new int[mat.length][mat[0].length];
        int m = mat.length, n = mat[0].length; // The distance of cells is up to (M+N)
        Queue<int[]> q = new ArrayDeque<>();

        // Adding all the zeroes to the QUEUE
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (mat[r][c] == 0) q.offer(new int[]{r, c});
                else mat[r][c] = -1; // Marked as not processed yet!


        while(!q.isEmpty()){
                int[] curr=q.poll();
                int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                    int nr=r+directions[i][0];
                    int nc=c+directions[i][1];
                    if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                    mat[nr][nc] = mat[r][c] + 1;
                    q.offer(new int[]{nr, nc});

            }

            }
        return mat;
    }

    public static void main(String[] args) {
        int gridSize = 3;
        int[][] grid = new int[gridSize][gridSize];
        Random random = new Random();

        // Fill the grid with random 0s and 1s
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = random.nextInt(2); // Generates random 0 or 1
            }
        }

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        int[][] ints = updateMatrix(grid);
        System.out.println("BREAK");
        // Print the grid
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.bill;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSAndBFS {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] grid2 = grid;
        bfsTraversal(grid);
        bfsAi(grid);
        // dfsTraversal(grid2);

        //dfsByAi(grid);
    }

    private static void bfsAi(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            System.out.println("AI Visiting element: " + grid[row][col]);

            // Check neighbors in all four directions
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check if the neighbor is within the grid and not visited
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

    }


    //DEPTH FIRST TRAVERSAL
    //Depth means Stack
    private static void dfsTraversal(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int minRow = 0;
        int minCol = 0;

        Stack<int[]> stack = new Stack<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        stack.push(new int[]{0, 0});
        visited[0][0] = true;

        while (!stack.isEmpty()) {
            int[] currentElement = stack.pop();
            int currentRow = currentElement[0];
            int currentCol = currentElement[1];
            System.out.println("current element is " + grid[currentRow][currentCol]);

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (inBoundary(newRow, newCol, minRow, minCol, maxRow, maxCol, visited)) {
                    stack.push(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }

            }
        }
    }

    private static boolean inBoundary(int newRow, int newCol, int minRow, int minCol, int maxRow, int maxCol, boolean[][] visited) {
        return newRow >= 0 && newRow < maxRow && newCol >= 0 && newCol < maxCol && !visited[newRow][newCol];
    }


    //BREADTH FIRST TRAVERSAL
    //Breadth means QUEUE

    private static void bfsTraversal(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int minRow = 0;
        int minCol = 0;

        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] currentElement = queue.poll();
            int currentRow = currentElement[0];
            int currentCol = currentElement[1];
            System.out.println("BFS current element is " + grid[currentRow][currentCol]);

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (inBoundary(newRow, newCol, minRow, minCol, maxRow, maxCol, visited)) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }

            }
        }
    }


    private static void dfsByAi(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        visited[0][0] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];

            System.out.println("Visiting element: " + grid[row][col]);

            // Check neighbors in all four directions
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check if the neighbor is within the grid and not visited
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    stack.push(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}

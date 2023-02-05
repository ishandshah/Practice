/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.array;


// Java program of the above approach

import java.util.Stack;

// LIFO
class DFSon2DArray {

    static int ROW = 3;
    static int COL = 3;

    // Initialize direction vectors
    static int[] dRow = {0, 1, 0, -1};
    static int[] dCol = {-1, 0, 1, 0};

    static Boolean isValid(Boolean[][] vis, int row,
                           int col) {

        // If cell is out of bounds
        if (row < 0 || col < 0 ||
                row >= ROW || col >= COL)
            return false;

        // If the cell is already visited
        return !vis[row][col];

        // Otherwise, it can be visited
    }

    // Function to perform DFS
//    Traversal on the matrix grid[]
    static void DFS(int row, int col, int[][] grid,
                    Boolean[][] vis) {

        // Initialize a stack of pairs and
        // push the starting cell into it
        Stack<pair> st = new Stack<pair>();
        st.push(new pair(row, col));

        // Iterate until the
        // stack is not empty
        while (!st.empty()) {

            // Pop the top pair
            pair curr = st.pop();

            row = curr.first;
            col = curr.second;

            // Check if the current popped
            // cell is a valid cell or not
            if (!isValid(vis, row, col))
                continue;

            // Mark the current
            // cell as visited
            vis[row][col] = true;

            // Print the element at
            // the current top cell
            System.out.print(grid[row][col] + " ");

            // Push all the adjacent cells
            for (int i = 0; i < 4; i++) {
                int adjx = row + dRow[i];
                int adjy = col + dCol[i];
                st.push(new pair(adjx, adjy));

            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[][] grid = {{-1, 2, 3},
                {0, 9, 8},
                {1, 0, 1}};

        Boolean[][] vis = new Boolean[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                vis[i][j] = false;
            }
        }
        long startTime = System.currentTimeMillis();
        // Function call
        DFS(0, 0, grid, vis);
        long endTime = System.currentTimeMillis();

        System.out.println("Hi" + (endTime - startTime));
    }

    static class pair {
        public int first;
        public int second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}


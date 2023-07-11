/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.random;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/*
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
 */

//TODO incorrect
public class Roomba {

    public static void main(String[] args) {
        int gridSize = 5;
        int[][] grid = new int[gridSize][gridSize];
        Random random = new Random();

        // Fill the grid with random 0s and 1s
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = random.nextInt(2); // Generates random 0 or 1
            }
        }
        // Print the grid
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        cleanTheRoom(grid);


    }

    private static void cleanTheRoom(int[][] grid) {
        Set<Pair> visited = new HashSet<>();
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        dfs(grid, visited, 0, 0, directions);

    }

    private static void dfs(int[][] grid, Set<Pair> visited, int iRow, int jColumn, int[][] directions) {


        if (checkBoundaryConditions(grid, visited, iRow, jColumn)) {
            visited.add(new Pair(iRow, jColumn));
            //cleaning
            System.out.println("Cleaning" + iRow + "Column" + jColumn);
            for (int i = 0; i < directions.length; i++) {
                int newRow = iRow + directions[i][0];
                int newCol = jColumn + directions[i][1];
                dfs(grid, visited, newRow, newCol, directions);
            }

        }


    }

    private static boolean checkBoundaryConditions(int[][] grid, Set<Pair> visited, int iRow, int jColumn) {

        return iRow >= 0 && jColumn >= 0 && iRow < grid.length && jColumn < grid[0].length && !visited.contains(new Pair(iRow, jColumn)) && grid[iRow][jColumn] != 0;
    }

    private static class Pair {
        int xRow;

        int yCol;

        public Pair(int xRow, int yCol) {
            this.xRow = xRow;
            this.yCol = yCol;
        }

        public int getxRow() {
            return xRow;
        }

        public int getyCol() {
            return yCol;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return xRow == pair.xRow && yCol == pair.yCol;
        }

        @Override
        public int hashCode() {
            return Objects.hash(xRow, yCol);
        }
    }
}

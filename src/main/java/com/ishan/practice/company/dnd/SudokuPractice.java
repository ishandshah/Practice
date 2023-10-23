/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd;


public class SudokuPractice {

    public static void main(String[] args) {


        int[][] sudokuGrid = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (solveSudoku(sudokuGrid)) {
            SudokuSolver.printSudoku(sudokuGrid);
        } else {
            System.out.println("No solution exists.");
        }
    }

    private static boolean solveSudoku(int[][] sudokuGrid) {
        int[] emptyCell = findEmptyCell(sudokuGrid);
        if (emptyCell == null) {
            System.out.println("solution already present.");
            return true; // All cells filled, puzzle solved
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int nums = 1; nums <= 9; nums++) {
            if (isValid(sudokuGrid, row, col, nums)) {
                sudokuGrid[row][col] = nums;

                if (solveSudoku(sudokuGrid)) {
                    return true;
                }
                //backtrack and set to zero
                sudokuGrid[row][col] = 0;
            }
        }

        return false;
    }

    private static boolean isValid(int[][] sudokuGrid, int row, int col, int nums) {
        for (int i = 0; i < 9; i++) {
            if (sudokuGrid[row][i] == nums || sudokuGrid[i][col] == nums) {
                return false;
            }
        }

        int subGridRow = row - (row % 3);
        int subGridCol = col - (col % 3);

        for (int i = subGridRow; i < subGridRow + 3; i++) {
            for (int j = subGridCol; j < subGridCol + 3; j++) {
                if (sudokuGrid[i][j] == nums) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[] findEmptyCell(int[][] sudokuGrid) {
        for (int i = 0; i < sudokuGrid.length; i++) {
            for (int j = 0; j < sudokuGrid[0].length; j++) {
                if (sudokuGrid[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.November.nov14;

/*
 * https://leetcode.com/problems/word-search/
 *   Given a string, determine if that string exists in a matrix, meaning if the sequence exists as a set of adjacent letters in the matrix.
 */
public class WordSearch {

    public static void main(String[] args) {
        String[][] board = {{"A", "B", "C", "E"}, {"S", "F", "C", "S"}, {"A", "D", "E", "E"}};
        String word = "ABCCED";

        boolean wordExists = new WordSearch().exist(board, word);
    }

    public boolean exist(String[][] board, String word) {
        // Row length
        int m = board.length;
        // Col length
        int n = board[0].length;
        boolean[][] used = new boolean[m][n]; // 17ms
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[m][n].charAt(0)) {
                    if (search(board, word, used, i, j, 0)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }


    private boolean search(String[][] board, String word, boolean[][] used, int row, int col, int index) {
        if (word.length() == index) {
            return true;
        }

        // Boundary conditions
        if (row < 0 || row >= board[0].length || col < 0 || col >= board.length) {
            return false;
        }

        if (used[row][col] == true || word.charAt(index) != board[row][col].charAt(0)) {
            return false;
        }
        used[row][col] = true;
        boolean match = search(board, word, used, row + 1, col, index + 1)
                || search(board, word, used, row, col, index + 1)
                || search(board, word, used, row, col + 1, index + 1)
                || search(board, word, used, row, col - 1, index + 1);


        used[row][col] = false;

        return match;
    }

}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.October.oct25;

//https://leetcode.com/problems/word-search/
//tODO
public class WordSearch {

    public static void main(String[] args) {
        // board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n]; // 17ms
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(search(board, word, used, j, i, 0)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, boolean[][] used, int x, int y, int index) {
        if (index == word.length()) return true;
        if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) return false;
        if (used[y][x] || board[y][x] != word.charAt(index)) return false;
        used[y][x] = true;
        boolean match = search(board, word, used, x+1, y, index+1)
                || search(board, word, used, x-1, y, index+1)
                || search(board, word, used, x, y+1, index+1)
                || search(board, word, used, x, y-1, index+1);
        used[y][x] = false;
        return match;
    }
}

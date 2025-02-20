/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.jan10;

public class WordSearch {
    static int m=0;
    static int n=0;
    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        // 'A','B','C','E'
        // 'S','F','C','S'
        // 'A','D','E','E'
        String word="ABCCED";

        boolean exist = exist(board, word);
        System.out.println("Present + " + exist);

    }
    public static boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        boolean[][] used = new boolean[m][n]; // 17ms

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j]){
                    if(wordCheck(i,j,board,word,0,used))
                            return true;
                }
            }
        }
        return false;
    }

    private static boolean wordCheck(int i, int j, char[][] board, String word,int index,boolean[][] used) {
        if (index == word.length()) return true;
        if(i<0 || i>= m || j<0 || j>=n || used[i][j])
            return false;

        if(board[i][j]!=word.charAt(index))
            return false;
        used[i][j]=true;




        return false;
    }

}

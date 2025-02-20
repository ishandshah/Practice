/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;

import java.util.LinkedList;
import java.util.Queue;

public class IslandCount {


    static int getNumberOfIslands(int[][] binaryMatrix) {
        // your code goes here

        int islands = 0;
        int rows = binaryMatrix.length;
        int col = binaryMatrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (binaryMatrix[i][j] == 1) {
                    islands++;
                    markIsland(binaryMatrix, rows, col, i, j);
                }

            }
        }
        return islands;
    }

    static void markIsland(int[][] binaryMatrix, int rows, int col, int currX, int currY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{currX, currY});

        while (!q.isEmpty()) {
            int[] current = q.poll();

            if(binaryMatrix[current[0]][current[1]]==1) {
                binaryMatrix[current[0]][current[1]]=-1;
                pushIfValid(q, rows, col, current[0] + 1, current[1]);
                pushIfValid(q, rows, col, current[0] - 1, current[1]);
                pushIfValid(q, rows, col, current[0], current[1] + 1);
                pushIfValid(q, rows, col, current[0], current[1] - 1);
            }
        }


    }

    static void pushIfValid(Queue<int[]> q, int rows, int cols, int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols)
            q.add(new int[]{x, y});
    }

    public static void main(String[] args) {
        int[][] binaryMatrix = { {0,    1,    0,    1,    0},
                {0,    0,    1,    1,    1},
                {1,    0,    0,    1,    0},
                {0,    1,    1,    0,    0},
                {1,    0,    1,    0,    1} };

        System.out.println(IslandCount.getNumberOfIslandsRecursively(binaryMatrix));
    }

    static int getNumberOfIslandsRecursively(int[][] binaryMatrix) {

        int islands=0;
        int row=binaryMatrix.length;
        int col=binaryMatrix[0].length;


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (binaryMatrix[i][j] == 1) {
                    islands++;
                    markIslandRecursive(binaryMatrix, row, col, i, j);
                }

            }
        }

    return islands;
    }

    private static void markIslandRecursive(int[][] binaryMatrix, int row, int col, int i, int j) {
        if(!isValid(row,col,i,j) || binaryMatrix[i][j]!=1){
            return;
        }
        binaryMatrix[i][j]=-1;
        markIslandRecursive(binaryMatrix,row,col,i-1,j);
        markIslandRecursive(binaryMatrix,row,col,i+1,j);
        markIslandRecursive(binaryMatrix,row,col,i,j-1);
        markIslandRecursive(binaryMatrix,row,col,i,j+1);




        }

    private static boolean isValid(int row, int col, int i, int j) {
        return i>=0 && i<row && j>=0 && j<col;
    }


}



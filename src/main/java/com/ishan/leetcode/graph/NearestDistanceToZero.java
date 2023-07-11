/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.graph;

public class NearestDistanceToZero {


    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        findDistance(matrix);


    }

    private static int[][] findDistance(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return null;

        int[][] answer = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = checkNeighbors(i, j, matrix);
                }

            }
        }


        return null;
    }

    private static int checkNeighbors(int i, int j, int[][] matrix) {
        int distance = 0;
        while (matrix[i][j] != 0) {
            distance++;
            callNeighbors(i, j, matrix);

        }
        return distance;
    }

    private static void callNeighbors(int i, int j, int[][] matrix) {

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
//            int x = matrix[0] + dir[0];
//            int y = matrix[1] + dir[1];
//            if(x >= 0 && x < r && y >= 0 && y < c && visited[x][y] == 0){
//                visited[x][y] = 1;
//                matrix[x][y] = step;
//                q.add(new int[]{x,y});
//            }
        }

    }

}

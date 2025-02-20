/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;

import java.util.*;

public class DashMartLeetcode {

        private static final char EMPTY = ' ';
        private static final char DASHMART = 'Z';
        private static final char GATE = 'X';
        private static final List<int[]> DIRECTIONS = Arrays.asList(
                new int[] { 1,  0},
                new int[] {-1,  0},
                new int[] { 0,  1},
                new int[] { 0, -1}
        );

        public static void main(String[] args) {
            char[][] locationBoard=
                    //        0   1     2   3    4    5    6    7    8
                           {{'X', ' ', ' ', 'Z', ' ', ' ', 'X', ' ', 'X'}, // 0
                            {'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' '}, //1
                            {' ', ' ', ' ', 'Z', 'X', 'X', ' ', 'X', ' '}, //2
                            {' ', ' ', ' ', 'Z', ' ', 'X', ' ', ' ', ' '}, //3
                            {' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X'}, //4
                            {' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X'}} ; //5

            boolean[][] isGate=new boolean[locationBoard.length][locationBoard[0].length];
            distanceToNearestGate(locationBoard,isGate);

            List<List<Integer>> locationList = Arrays.asList( Arrays.asList(1,4), Arrays.asList(0,3), Arrays.asList(5,8)
            ,Arrays.asList(1,8),Arrays.asList(5,5));
            List<Integer> answer = new ArrayList<>();
            for (List<Integer> location : locationList) {
                // add location validation here
                if(isGate[location.get(0)][location.get(1)]){
                    answer.add(-1);
                }else {
                    answer.add(locationBoard[location.get(0)][location.get(1)] - 'Z');
                }
            }

            //locations = [
            //    [200, 200],
            //    [1, 4],
            //    [0, 3],
            //    [5, 8],
            //    [1, 8],
            //    [5, 5]
            //]
            //
            //answer = [-1, 2, 0, -1, 6, 9]
            System.out.println(answer);
        }

        private static char[][] distanceToNearestGate(char[][] rooms, boolean[][] isGate) {
            int m = rooms.length;
            if (m == 0) return rooms;
            int n = rooms[0].length;
            Queue<int[]> q = new LinkedList<>();
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (rooms[row][col] == DASHMART) {
                        q.add(new int[] { row, col });
                    }else if (rooms[row][col] == GATE) {
                        isGate[row][col]=Boolean.TRUE;
                    }
                }
            }
            while (!q.isEmpty()) {
                int[] point = q.poll();
                int row = point[0];
                int col = point[1];
                for (int[] direction : DIRECTIONS) {
                    int r = row + direction[0];
                    int c = col + direction[1];
                    if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                        continue;
                    }
                    rooms[r][c] = (char)(rooms[row][col] + 1);
                    q.add(new int[] { r, c });
                }
            }
            return rooms;
        }

}

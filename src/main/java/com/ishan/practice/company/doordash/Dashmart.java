/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
User
A DashMart is a warehouse run by DoorDash that houses items found in convenience stores, grocery stores, and restaurants.
We have a city with open roads, blocked-off roads, and DashMarts.

City planners want you to identify how far a location is from its closest DashMart.

You can only travel over open roads (up, down, left, right).

Locations are given in [row, col] format.

// Example 1
// [
// #     0    1    2    3    4    5    6    7    8
    ['X', ' ', ' ', 'D', ' ', ' ', 'X', ' ', 'X'], # 0
    ['X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X'], # 1
    [' ', ' ', ' ', 'D', 'X', 'X', ' ', 'X', ' '], # 2
    [' ', ' ', ' ', 'D', ' ', 'X', ' ', ' ', ' '], # 3
    [' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X'], # 4
    [' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X']  # 5
]

' ' represents an open road that you can travel over in any direction (up, down, left, or right).
'X' represents an blocked road that you cannot travel through.
'D' represents a DashMart.

# list of pairs [row, col]
locations = [
    [200, 200],
    [1, 4],
    [0, 3],
    [5, 8],
    [1, 8],
    [5, 5]
]

answer = [-1, 2, 0, -1, 6, 9]

Provided:
city: char[][]
locations: int[][2]

Return:
answer: int[]
 */
public class Dashmart {

    public static void main(String[] args) {
        char[][] input=
    //    0   1     2   3    4    5    6    7    8
       {{'X', ' ', ' ', 'D', ' ', ' ', 'X', ' ', 'X'}, // 0
        {'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', 'X'}, //1
        {' ', ' ', ' ', 'D', 'X', 'X', ' ', 'X', ' '}, //2
        {' ', ' ', ' ', 'D', ' ', 'X', ' ', ' ', ' '}, //3
        {' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X'}, //4
        {' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X', 'X'}} ; //5



        int[][] locations= {
                {1, 8},
                {5, 5}};

        // answer = [-1, 2, 0, -1, 6, 9]


        //System.out.println(Arrays.toString(findDashMartBFS(input,locations)));

        findDashMartPreCalculated(input,locations);


    }
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );
    private static void findDashMartPreCalculated(char[][] input, int[][] locations) {
        int m = input.length;
        if (m == 0) return;
        int n = input[0].length;
        int l=(m * n);
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (input[row][col] == 'D') {
                    input[row][col]= '0';
                    q.add(new int[] { row, col });
                }else if(input[row][col] == ' '){
                    input[row][col]= (char)l ;
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

                if (r < 0 || c < 0 || r >= m || c >= n || input[r][c] == 'X'
                || Character.getNumericValue(input[r][c]) < Character.getNumericValue(input[row][col]) +1) {
                    continue;
                }
                input[r][c] = (char) (Character.getNumericValue(input[row][col]) + 1);
                q.add(new int[] { r, c });
            }
        }

        for(int[] loc:locations){
            System.out.println(input[loc[0]][loc[1]]);
        }

    }

    private static int[] findDashMartBFS(char[][] input, int[][] locations) {
        int[] answer=new int[locations.length];
        int rows=input.length;
        int cols=input[0].length;
        int i=0;
        int steps=0;
        for(int[] location:locations){
            int x=location[0];
            int y=location[1];
            if(isValid(x,y,input))
                answer[i]=findPath(input,x,y,new boolean[rows][cols]);
            else
                answer[i]=-1;
            i++;
        }
        return answer;
    }

    private static int findPath(char[][] input, int x, int y,boolean[][] visited) {
        if(input[x][y]=='D'){
            return 0;
        }
        visited[x][y]=true;
        Integer minDistance = Integer.MAX_VALUE;

        minDistance=Math.min(minDistance,findPathHelper(input,x+1,y,visited));
        minDistance=Math.min(minDistance,findPathHelper(input,x-1,y,visited));
        minDistance=Math.min(minDistance,findPathHelper(input,x,y+1,visited));
        minDistance=Math.min(minDistance,findPathHelper(input,x,y-1,visited));

        visited[x][y] = false;

        return minDistance==Integer.MAX_VALUE?-1:minDistance+1;

    }

    private static Integer findPathHelper(char[][] input, int x, int y, boolean[][] visited) {
        if(isValid(x,y,input) && !visited[x][y]){
            return findPath(input,x,y,visited);
        }
        return Integer.MAX_VALUE;
    }

    private static boolean isValid(int x, int y,char[][] input) {
        return x>=0 && x<input.length && y>=0 && y<input[0].length && input[x][y] !='X';
    }
}

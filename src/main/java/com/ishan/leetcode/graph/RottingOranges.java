/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.graph;


//https://leetcode.com/problems/rotting-oranges/

import java.util.LinkedList;
import java.util.Queue;

// Try bfs solution first
public class RottingOranges {
    //Input: grid = [[2,1,1],[0,1,1],[1,0,1]]


    // store the position of rotten orange
    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Position> q = new LinkedList<>();
        int total = 0, rotten = 0, time = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]==2){
                    q.offer(new Position(i,j));
                }
                if(grid[i][j]==1 || grid[i][j]==2 ){
                    total++;
                }
            }
        }


        if(total==0)
            return 0;

        while(!q.isEmpty() && rotten<total){
            // size is the num of rotten oranges of the last round
            int size = q.size();

            // count the num of rotten oranges, if it equals to total num, return time;
            rotten += size;
            if (rotten == total) return time;

            // every round, time ++
            time++;


            // Continue to dequeue until all rotten oranges of last round are removed from the queue
            for (int i = 0; i < size; i++) {
                Position p = q.peek();

                // check the cell in the left/right/top/down of the rotten orange, if it is a fresh orange, enqueue it.
                if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1) {
                    grid[p.x + 1][p.y] = 2;
                    q.offer(new Position(p.x + 1, p.y));
                }
                if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
                    grid[p.x - 1][p.y] = 2;
                    q.offer(new Position(p.x - 1, p.y));
                }
                if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1) {
                    grid[p.x][p.y + 1] = 2;
                    q.offer(new Position(p.x, p.y + 1));
                }
                if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1) {
                    grid[p.x][p.y - 1] = 2;
                    q.offer(new Position(p.x, p.y - 1));
                }
                q.poll();
            }
        }

        return -1;
    }
}
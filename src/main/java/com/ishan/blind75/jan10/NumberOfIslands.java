/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.jan10;

//https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] matrix={{0,1,1,0},{0,0,1,0},{0,0,0,1}};

        System.out.println(numIslands(matrix));
    }

    public static int numIslands(int[][] grid) {
        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==1){
                count++;
                shrink(i,j,grid);
            }
        }
        }

        return count;
    }

    private static void shrink(int i, int j, int[][] grid) {
        if(i<0 || i>grid.length - 1 ||j<0 || j> grid[0].length -1 || grid[i][j]==0 )
            return;
        grid[i][j]=0;
        shrink(i-1,j,grid);
        shrink(i+1,j,grid);
        shrink(i,j-1,grid);
        shrink(i,j+1,grid);

    }


}

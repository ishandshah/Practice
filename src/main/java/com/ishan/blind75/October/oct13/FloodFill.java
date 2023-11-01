/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.October.oct13;

//https://leetcode.com/problems/flood-fill/description/
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        // previous value
        floodFillUtil(image, sr, sc, color, image[sr][sc]);
        return image;
    }


    public void floodFillUtil(int[][] image, int sr, int sc, int color, int previousColor) {

        //checkBoundaryConditions(if)
        if (sr < 0 || sc < 0 || sr > image.length - 1 || sc > image[0].length - 1) {
            return;
        }

        if (image[sr][sc] == previousColor) {
            image[sr][sc] = color;
        } else {
            return;
        }
        floodFillUtil(image, sr - 1, sc, color, previousColor);
        floodFillUtil(image, sr, sc - 1, color, previousColor);
        floodFillUtil(image, sr + 1, sc, color, previousColor);
        floodFillUtil(image, sr, sc + 1, color, previousColor);


    }
}

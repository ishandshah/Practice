/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.jan7;

import java.util.Arrays;

//https://leetcode.com/problems/flood-fill/description/
public class Floodfill {

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;

        if(image[sr][sc]==color){
            System.out.println("done");
            System.exit(0);
        }

        floodfillUtil(image,sr,sc,image[sr][sc],color);
        System.out.println(Arrays.deepToString(image));
    }

    private static void floodfillUtil(int[][] image, int sr, int sc, int prevColor, int color) {

    if(sr>image.length-1 || sr<0 || sc>image[0].length -1 || sc<0){
        return;
    }

    if(image[sr][sc]==prevColor){
        image[sr][sc]=color;
    }else{
        return;
    }
        floodfillUtil(image, sr - 1,  sc,  prevColor, color);
        floodfillUtil(image, sr,  sc -1,  prevColor, color);
        floodfillUtil(image, sr + 1,  sc,  prevColor, color);
        floodfillUtil(image, sr,  sc +1,  prevColor, color);

    }
}

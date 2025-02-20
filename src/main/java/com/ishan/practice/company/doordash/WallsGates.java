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
import java.util.Queue;

public class WallsGates {


    public static void main(String[] args) {
        int[][] rooms = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        int[][] ints = new WallsGates().wallsAndGates(rooms);

        for(int i=0;i< ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }

    private int[][] wallsAndGates(int[][] rooms) {

        int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};

        Queue<int[]> gates=getGates(rooms);

         while(!gates.isEmpty()){

             int[] point=gates.poll();

             int currentX=point[0];
             int currentY=point[1];

             for(int[] dirre:directions){

                 int nr=currentX+dirre[0];
                 int nc=currentY+dirre[1];

                 if(nr<0|| nr>rooms.length-1||nc<0|| nc> rooms[0].length-1||
                 rooms[nr][nc]<rooms[currentX][currentY]+1){
                     continue;
                 }

                 rooms[nr][nc]=rooms[currentX][currentY] +1;
                 gates.add(new int[]{nr,nc});
             }

         }


        return rooms;
    }

    private Queue<int[]> getGates(int[][] rooms) {
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i< rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                        queue.add(new int[]{i,j});
                }
            }
        }

        return queue;
    }
}

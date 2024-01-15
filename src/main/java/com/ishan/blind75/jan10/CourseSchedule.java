/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.jan10;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule {

    public static void main(String[] args) {
        int[][] pre=new int[][]{{0,1},{1,3},{2,3}};
        int numCourses=4;

        List<List<Integer>> courses=new ArrayList<>(numCourses);

        for(int i=0;i<numCourses;i++){
            courses.add(new ArrayList<>());
        }

        for(int i=0;i< pre.length;i++){
            courses.get(pre[i][1]).add(pre[i][0]);
        }
        int[] visited=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!dfs(i,courses,visited)){
                System.out.println("FALSE");
                break;
            }

        }
        System.out.println("Successful");

    }

    private static boolean dfs(int i, List<List<Integer>> courses, int[] visited) {
        visited[i]=1;

        List<Integer> childCourses=courses.get(i);

        for(int x:childCourses){

            if(visited[x]==1) return false;
            if(!dfs(x,courses,visited)) return false;
        }

        visited[i]=2;
        return true;
    }
}

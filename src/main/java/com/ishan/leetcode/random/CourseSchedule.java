/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.random;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Doesn't check for cyclic course
//todo
// https://leetcode.com/problems/course-schedule/description/
public class CourseSchedule {


    private static void dfs(int i, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> integerStack) {
        // Traverse on neighboring vertices
        for (Integer neighbor : adjList.get(i)) {
            if (visited[neighbor] != true) {
                dfs(neighbor, adjList, visited, integerStack);
            }
        }

        if (visited[i] != true)
            integerStack.add(i);
        visited[i] = true;

    }

    public static void main(String[] args) {
        int[][] prereq = {{1, 0}};

        System.out.println(new CourseSchedule().canFinish(2, prereq));
    }

    boolean canFinish(int courses, int[][] prerequisites) {
        boolean[] visited = new boolean[courses];
        Stack<Integer> integerStack = new Stack<>();

        //Build cycle
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < courses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] a : prerequisites) {
            adjList.get(a[1]).add(a[0]);
        }

        System.out.println(adjList);

        for (int i = 0; i < courses; i++) {
            if (visited[i] != true) {
                //   visited[i]=true;
                dfs(i, adjList, visited, integerStack);
                //  visited[i]=false;
            }
        }
        // int[] answer=new int[courses];


        return integerStack.size() == courses;
    }
}

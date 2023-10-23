/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
* There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
*
* DFS + Stack + visited[]
* Space Complexity: O (V +E)
* Time Complexity:
* */
//todo not completed yet
public class TopologicalSort {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        // {1,0},{2,0},{3,1},{3,2}
        int[] output = findOrder(prerequisites, 4);
        System.out.println(Arrays.toString(output));

        // [0,1],[1,0]
    }

    private static int[] findOrder(int[][] prerequisites, int courses) {

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
        int[] answer = new int[courses];
        int j = 0;
        while (!integerStack.isEmpty()) {
            System.out.println(integerStack);
            answer[j++] = integerStack.pop();
            System.out.println(j);
        }

        return answer;
    }

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

}

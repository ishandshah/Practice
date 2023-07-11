/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.graph;


/* You have a build system where a package cannot be built before its dependencies do.
Given a list of packages and the dependencies for each package,
write a method that will sort these packages in the correct order so that all dependencies are built beforehand.
E.g. for A -> [B, C] and C -> D, the ordering can be either B, D, C, A or D, B, C, A
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class PackageDependency {

    public static void main(String[] args) {
        GFG.Graph g = new GFG.Graph(5);
        Set<Integer> vertices=new HashSet<>();
        g.addEdge(0, 1);

        vertices.add(3);
        vertices.add(0);
        vertices.add(4);
        vertices.add(1);
        vertices.add(2);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
     //   g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        scheduleTasks(g,vertices);
    }


    public static List<Integer> scheduleTasks(GFG.Graph g, Set<Integer> vertices){
        Set<Integer> visited=new HashSet<>();
        Stack<Integer> stackedValues=new Stack<>();

        for(Integer s:vertices){
            System.out.println("vertice" + s);
                if(!visited.contains(s)){
                    visited.add(s);
                    scheduleTasksUtil(visited,s,stackedValues,g);
                }

        }

      //  System.out.println(stackedValues.size());
        while(!stackedValues.isEmpty()){
            System.out.println(stackedValues.pop());
        }

        return null;
    }

    private static void scheduleTasksUtil(Set<Integer> visited, Integer s, Stack<Integer> stackedValues,GFG.Graph G) {


        for(Integer child:G.adj[s]){
            if(!visited.contains(child)){
                visited.add(child);
                scheduleTasksUtil(visited,child,stackedValues,G);
            }

        }

        stackedValues.add(s);
    }
}

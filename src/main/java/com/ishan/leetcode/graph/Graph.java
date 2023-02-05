/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private final int V; // No. of vertices

    // Array  of lists for Adjacency List Representation
    private final LinkedList<Integer>[] adj;

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }


    public void BFS(int i) {

        //Breadth first search so a QUEUE
        boolean[] visited = new boolean[V];
        Queue<Integer> edges = new LinkedList<>();


        edges.offer(i);
        visited[i] = true;
        while (!edges.isEmpty()) {

            Integer peek = edges.poll();

            System.out.println("Edge" + peek);

            Iterator<Integer> iter = adj[peek].listIterator();

            while (iter.hasNext()) {
                Integer vale = iter.next();
                if (!visited[vale]) {
                    edges.offer(vale);
                    visited[vale] = true;
                }
            }
        }

    }

    public void DFS(int i) {

        //Breadth first search so a QUEUE
        boolean[] visited = new boolean[V];
        Stack<Integer> edges = new Stack<>();


        edges.add(i);
        visited[i] = true;
        while (!edges.isEmpty()) {

            Integer peek = edges.pop();

            System.out.println("Edge" + peek);

            Iterator<Integer> iter = adj[peek].listIterator();

            while (iter.hasNext()) {
                Integer vale = iter.next();
                if (!visited[vale]) {
                    edges.add(vale);
                    visited[vale] = true;
                }
            }
        }

    }
}

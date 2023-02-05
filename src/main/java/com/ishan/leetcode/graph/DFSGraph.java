/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.graph;

import java.util.LinkedList;
import java.util.Stack;

public class DFSGraph {


    private final int V; // No. of vertices

    // Array  of lists for
    // Adjacency List Representation
    private final LinkedList<Integer>[] adj;

    // Constructor
    DFSGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {
        DFSGraph g = new DFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        // Function call
        // g.DFS(2);

        g.iterativeDFS();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    private void iterativeDFS() {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        //  visited[i]=true;
        st.push(2);
        while (!st.isEmpty()) {
            Integer pop = st.pop();
            System.out.println("Iterative" + pop);
            visited[pop] = true;
            for (int j = 0; j < adj[pop].size(); j++) {
                Integer integerLocal = adj[pop].get(j);
                System.out.println("integerLocal" + integerLocal);
                if (!visited[integerLocal]) {
                    st.push(integerLocal);
                }
            }

        }

    }


    // A function used by DFS
    void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.println(v + " ");

        // Recursively for all the vertices adjacent to this
        // vertex
        for (int n : adj[v]) {
            // System.out.println("Test for " +v +"is" + n);
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v) {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }
}


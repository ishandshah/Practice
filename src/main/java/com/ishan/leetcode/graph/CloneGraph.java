/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CloneGraph {

    public static void main(String[] args) {
        // Create a sample graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        Node clonedGraph = cloneGraph(node1);

        // Print the cloned graph
        printGraph(clonedGraph);
    }

    public static void printGraph(Node node) {
        HashSet<Node> visited = new HashSet<>();
        dfsTraversal(node, visited);
    }

    private static void dfsTraversal(Node node, HashSet<Node> visited) {

        System.out.println(node.val + "");
        visited.add(node);

        for (Node child : node.neighbors) {
            if (!visited.contains(child)) {
                dfsTraversal(child, visited);
            }
        }
    }


    private static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Create a HashMap to store the cloned nodes
        HashMap<Node, Node> visited = new HashMap<>();

        // Perform DFS to clone the graph
        return cloneNode(node, visited);
    }

    private static Node cloneNode(Node node, HashMap<Node, Node> visited) {
        // Check if the current node has already been visited (cloned)
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val);

        // Add the clone to the visited map
        visited.put(node, clone);

        // Recursively clone the neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneNode(neighbor, visited));
        }
        return clone;
    }
}

class Node {
    int val;
    List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}
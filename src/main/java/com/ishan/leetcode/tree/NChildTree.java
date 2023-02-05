/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NChildTree {

    // Prints the n-ary tree level wise
    static void LevelOrderTraversal(Node root) {
        if (root == null)
            return;

        // Standard level order traversal code
        // using queue
        Queue<Node> q = new LinkedList<>(); // Create a queue
        q.add(root); // Enqueue root
        while (!q.isEmpty()) {
            int n = q.size();

            // If this node has children
            while (n > 0) {
                // Dequeue an item from queue
                // and print it
                Node p = q.peek();
                q.remove();
                System.out.print(p.value + " ");

                // Enqueue all children of
                // the dequeued item
                for (int i = 0; i < p.child.size(); i++)
                    q.add(p.child.get(i));
                n--;
            }

            // Print new line between two levels
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        (root.child).add(new Node(2));
        (root.child).add(new Node(34));
        (root.child).add(new Node(56));
        (root.child).add(new Node(100));
        (root.child.get(0).child).add(new Node(77));
        (root.child.get(0).child).add(new Node(88));
        (root.child.get(2).child).add(new Node(1));
        (root.child.get(3).child).add(new Node(7));
        (root.child.get(3).child).add(new Node(8));
        (root.child.get(3).child).add(new Node(9));

        System.out.println("Level order traversal " +
                "Before Mirroring ");
        LevelOrderTraversal(root);
    }

    static class Node {
        int value;
        List<Node> child;

        Node(int val) {
            value = val;
            child = new ArrayList<>();
        }
    }
}

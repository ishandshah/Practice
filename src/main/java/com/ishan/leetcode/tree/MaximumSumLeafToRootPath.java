/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.tree;

public class MaximumSumLeafToRootPath {

    Node root;
    int max_no = Integer.MIN_VALUE;
    Node target_leaf = null;

    // driver function to test the above functions
    public static void main(String[] args) {
        MaximumSumLeafToRootPath tree = new MaximumSumLeafToRootPath();
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        System.out.println("Following are the nodes "
                + "on maximum sum path");
        int sum = tree.maxSumPath();
        System.out.println();
        System.out.println("Sum of nodes is : " + sum);
    }

    // A utility function that prints all nodes on the
    // path from root to target_leaf
    boolean printPath(Node node, Node target_leaf) {
        // base case
        if (node == null)
            return false;

        // return true if this node is the target_leaf or
        // target leaf is present in one of its descendants
        if (node == target_leaf || printPath(node.left, target_leaf)
                || printPath(node.right, target_leaf)) {
            System.out.print(node.data + " ");
            return true;
        }

        return false;
    }

    // This function Sets the target_leaf_ref to refer
    // the leaf node of the maximum path sum. Also,
    // returns the max_sum using max_sum_ref
    void getTargetLeaf(Node node, int max_sum_ref,
                       int curr_sum) {
        if (node == null)
            return;

        // Update current sum to hold sum of nodes on
        // path from root to this node
        curr_sum = curr_sum + node.data;

        // If this is a leaf node and path to this node
        // has maximum sum so far, the n make this node
        // target_leaf
        if (node.left == null && node.right == null) {
            if (curr_sum > max_sum_ref) {
                max_no = curr_sum;
                target_leaf = node;
            }
        }

        // If this is not a leaf node, then recur down
        // to find the target_leaf
        getTargetLeaf(node.left, max_sum_ref, curr_sum);
        getTargetLeaf(node.right, max_sum_ref, curr_sum);
    }

    // Returns the maximum sum and prints the nodes on
    // max sum path
    int maxSumPath() {
        // base case
        if (root == null)
            return 0;

        // find the target leaf and maximum sum
        getTargetLeaf(root, max_no, 0);

        // print the path from root to the target leaf
        printPath(root, target_leaf);
        return max_no; // return maximum sum
    }
}


// Java program to find maximum sum leaf to root
// path in Binary Tree

// A Binary Tree node
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

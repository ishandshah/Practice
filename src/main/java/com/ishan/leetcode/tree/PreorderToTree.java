/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.tree;

public class PreorderToTree {
    private int index; // Global variable to keep track of current index in the array

    public static void main(String[] args) {
        int[] preorder = {5, 3, 2, 4, 8, 7, 9};

        PreorderToTree converter = new PreorderToTree();
        TreeNode root = converter.buildTree(preorder);

        System.out.println("Root value: " + root.val);
    }

    private TreeNode buildTree(int[] preorder) {
        index = 0; // Initialize index to 0
        return buildTreeHelper(preorder, Integer.MAX_VALUE); // Call the recursive helper function
    }

    private TreeNode buildTreeHelper(int[] preorder, int bound) {
        if (index >= preorder.length || preorder[index] > bound) {
            return null; // Return null if index is out of bounds or current value exceeds the bound
        }
        int currentValue = preorder[index++]; // Get the current value and increment the index

        TreeNode root = new TreeNode(currentValue); // Create a new node with the current value

        root.left = buildTreeHelper(preorder, currentValue); // Recursively build the left subtree
        root.right = buildTreeHelper(preorder, bound); // Recursively build the right subtree

        return root; // Return the root node

    }
}

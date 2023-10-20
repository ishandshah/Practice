/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct19;

import com.ishan.leetcode.tree.TreeNode;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().populateTree();
        invertTree(treeNode);
    }

    public static TreeNode invertTree(TreeNode root) {

        // Base case: if the tree is empty...
        if (root == null) {
            return root;
        }
        // Call the function recursively for the left subtree...
        invertTree(root.left);
        // Call the function recursively for the right subtree...
        invertTree(root.right);
        // Swapping process...
        TreeNode curr = root.left;
        root.left = root.right;
        root.right = curr;
        return root;        // Return the root...

    }
}

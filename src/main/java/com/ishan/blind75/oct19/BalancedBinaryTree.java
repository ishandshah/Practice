/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct19;

import com.ishan.leetcode.tree.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {

    public static void main(String[] args) {

        System.out.println(new BalancedBinaryTree().isBalanced(new TreeNode().populateTree()));
    }
    public boolean isBalanced(TreeNode root) {
        // If the tree is empty, we can say it’s balanced...
        if (root == null)  return true;
        // Height Function will return -1, when it’s an unbalanced tree...
        if (Height(root) == -1)  return false;
        return true;
    }
    // Create a function to return the “height” of a current subtree using recursion...
    public int Height(TreeNode root) {
        // Base case...
        if (root == null)  return 0;
        // Height of left subtree...
        int leftHeight = Height(root.left);
        // Height of height subtree...
        int rightHeight = Height(root.right);
        // In case of left subtree or right subtree unbalanced, return -1...
        if (leftHeight == -1 || rightHeight == -1)  return -1;
        // If their heights differ by more than ‘1’, return -1...
        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
        // Otherwise, return the height of this subtree as max(leftHeight, rightHight) + 1...
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

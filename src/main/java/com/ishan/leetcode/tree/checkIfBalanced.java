/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.tree;


public class checkIfBalanced {


    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        return Math.max(lheight, rheight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
            //All Nodes in the tree have an Absolute Difference of Left Height & Right Height not more than 1.
        } else if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

}

class TreeNode {


    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

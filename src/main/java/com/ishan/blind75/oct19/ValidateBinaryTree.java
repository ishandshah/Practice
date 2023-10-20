/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct19;

// TODO Refer https://leetcode.com/problems/validate-binary-search-tree/solutions/32112/learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution/

import com.ishan.leetcode.tree.TreeNode;

import java.util.Stack;

// TODO Code fails when the child's child has  a value lesser than the root
public class ValidateBinaryTree {

    Boolean isValid=Boolean.TRUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return isValid;

        if(!isValid){
            return Boolean.FALSE;

        }


        if(root.left!=null){
            if(root.left.val >= root.val) {
                isValid=Boolean.FALSE;
                return Boolean.FALSE;
            }else{
                isValidBST(root.left);
            }
        }

        if(root.right!=null){
            if(root.right.val<=root.val) {
                isValid=Boolean.FALSE;
                return Boolean.FALSE;
            }else{
                isValidBST(root.right);
            }
        }
        return isValid;
    }

    public boolean isValidBSTWorking(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}

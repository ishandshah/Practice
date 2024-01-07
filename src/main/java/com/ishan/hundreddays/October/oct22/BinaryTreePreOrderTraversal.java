/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.October.oct22;

import com.ishan.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreOrderTraversal {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().populateTree();


        List<Integer> integers = preorderTraversal(treeNode);
        System.out.println(integers);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new LinkedList<>();
        Stack<TreeNode> integerStack = new Stack<>();

        if (root != null) {
            integerStack.push(root);
        }

        while (!integerStack.isEmpty()) {
            //
            TreeNode pop = integerStack.pop();

            lst.add(pop.val);
            if (pop.right != null) {
                integerStack.push(pop.right);
            }

            if (pop.left != null) {
                integerStack.push(pop.left);
            }
        }
        return lst;
    }
}

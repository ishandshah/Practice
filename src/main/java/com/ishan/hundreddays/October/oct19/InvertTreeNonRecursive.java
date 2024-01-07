/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.October.oct19;

import com.ishan.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Follow up to https://leetcode.com/problems/invert-binary-tree/ to do iteratively via BFS or DFS
public class InvertTreeNonRecursive {
    static List<Integer> addList = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().populateTree();
        invertTreeNonRecursive(treeNode);
    }

    private static void invertTreeNonRecursive(TreeNode root) {
        //DFS Stack LIFO

        if (root == null) {
            System.out.println("TATA");
        }

        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            addList.add(pop.val);
            TreeNode curr = pop.left;
            pop.left = pop.right;
            pop.right = curr;


            if (pop.left != null) {
                System.out.println("Pop.left" + pop.left.val);
                stack.push(pop.left);
            }

            if (pop.right != null) {
                stack.push(pop.right);
            }
        }

        //return root;
        addList.stream().forEach(System.out::println);
    }


}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct26;

import com.ishan.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-postorder-traversal/description/
public class BinaryTreePostOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().populateTree();


        List<Integer> integers = postOrderTraversal(treeNode);
        System.out.println(integers);
    }

    private static List<Integer> postOrderTraversal(TreeNode treeNode) {
        Stack<TreeNode> postStack=new Stack<>();
        List<Integer> integerList=new ArrayList<>();


        if (treeNode != null) {

          //  postStack.push()
        }


        return null;
    }
}

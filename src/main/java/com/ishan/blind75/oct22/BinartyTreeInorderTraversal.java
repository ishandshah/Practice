/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct22;

import com.ishan.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinartyTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().populateTree();


        List<Integer> integers = inOrder(treeNode);
        System.out.println(integers);
    }

    private static  List<Integer> inOrder(TreeNode root) {
        Stack<TreeNode> treeNodeStack=new Stack<>();
        List<Integer> list = new ArrayList<>();

        while(root!=null || !treeNodeStack.isEmpty()){
            while(root!=null){
                treeNodeStack.push(root);
                root=root.left;
            }
            root=treeNodeStack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }
    }


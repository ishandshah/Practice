/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.October.oct13;

import com.ishan.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindPath {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().populateTree();

        System.out.println(findPath(treeNode, new ArrayList<>(), new TreeNode(13)));
    }


    public static boolean findPath(TreeNode node, List<TreeNode> arr, TreeNode target) {
        if (node == null)
            return false;

        arr.add(node);
        // if it is the required node
        // return true
        if (node.val == target.val)
            return true;
        if (findPath(node.left, arr, target) || findPath(node.right, arr, target))
            return true;

        arr.remove(arr.size() - 1);
        return false;
    }
}

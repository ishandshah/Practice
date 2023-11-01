/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.October.oct13;

import com.ishan.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

// Really good solution https://www.youtube.com/watch?v=13m9ZCB8gjw&ab_channel=TusharRoy-CodingMadeSimple
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//TODO better recursive way to solve this
public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> route1 = new LinkedList<>();
        List<TreeNode> route2 = new LinkedList<>();
        if (findPath(root, route1, p) && findPath(root, route2, q)) {
            int i;
            for (i = 0; i < route1.size() && i < route2.size();
                 i++) {

                // System.out.println(path1.get(i) + " " +
                // path2.get(i));
                if (!route1.get(i).equals(route2.get(i)))
                    break;
            }

            return route1.get(i - 1);
        }
        return null;
    }

    public boolean findPath(TreeNode root, List<TreeNode> arr, TreeNode x) {
        // if root is NULL
        // there is no path
        if (root == null)
            return false;

        // push the node's value in 'arr'
        arr.add(root);

        // if it is the required node
        // return true
        if (root.val == x.val)
            return true;

        // else check whether the required node lies
        // in the left subtree or right subtree of
        // the current node
        if (findPath(root.left, arr, x) ||
                findPath(root.right, arr, x))
            return true;

        // required node does not lie either in the
        // left or right subtree of the current node
        // Thus, remove current node's value from
        // 'arr'and then return false
        arr.remove(arr.size() - 1);
        return false;
    }

}

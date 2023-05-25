/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.tree;

import java.util.ArrayList;


// todo
public class DistanceBetweenLeafNodes {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        getPath(root, p, path1);
        getPath(root, q, path2);

        int i=0;
        int counter=0;
        for(; i<path1.size() && i<path2.size();i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
            return path1.get(i-1);
    }

    public static boolean getPath(TreeNode root, TreeNode n, ArrayList<TreeNode> list){
        if(root == null){
            return false;
        }

        list.add(root);

        if(root.val == n.val){
            return true;
        }
        boolean foundLeft = getPath(root.left,n,list);
        boolean foundRight = getPath(root.right,n,list);

        if(foundLeft || foundRight){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode().populateTree();
        TreeNode lcaNode = new DistanceBetweenLeafNodes().lowestCommonAncestor(node, new TreeNode(8), new TreeNode(14));
        findDistance(lcaNode,8,14);
    }

    // Returns level of key k if it is present in
    // tree, otherwise returns -1
    public static int findLevel(TreeNode root, int a, int level)
    {
        if (root == null)
            return -1;
        if (root.val == a)
            return level;
        int left = findLevel(root.left, a, level + 1);
        if (left == -1)
            return findLevel(root.right, a, level + 1);
        return left;
    }

    public static int findDistance(TreeNode lca, int a, int b)
    {

        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);

        return d1 + d2;
    }
}

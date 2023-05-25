/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.tree;

import java.util.ArrayList;

public class LowestCommonAncestor {
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        getPath(root, p, path1);
        getPath(root, q,path2);

        //lca
        int i=0;
        for(; i<path1.size() && i<path2.size();i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        TreeNode lca = path1.get(i-1);
        return lca;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode().populateTree();
        TreeNode treeNode = new LowestCommonAncestor().lowestCommonAncestor(node, new TreeNode(8), new TreeNode(14));
        System.out.println(treeNode.val);
    }
}

/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;


import com.ishan.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

// Binary tree
public class LCA {
    public static void main(String[] args) {
        TreeNode node = new TreeNode().populateTree();
        TreeNode treeNode = new LCA().lowestCommonAncestor(node, new TreeNode(8), new TreeNode(14));
        System.out.println(treeNode.val);
    }

    private TreeNode lowestCommonAncestor(TreeNode node, TreeNode treeNode, TreeNode treeNode1) {
        List<TreeNode> path1=new ArrayList<>();
        List<TreeNode> path2=new ArrayList<>();

        getPath(node,treeNode,path1);
        getPath(node,treeNode1,path2);

        int i=0;
        for(;i< path1.size() && i < path2.size(); i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }


        return path1.get(i-1);
    }

    private boolean getPath(TreeNode node, TreeNode treeNode, List<TreeNode> path1) {

        if(node==null){
            return false;
        }

        path1.add(node);
        if(node.val==treeNode.val){
            return true;
        }

        boolean foundLeft=getPath(node.left,treeNode,path1);
        boolean foundRight=getPath(node.right,treeNode,path1);


        if(foundLeft|| foundRight){
            return true;
        }

        path1.remove(path1.size()-1);
        return false;


    }


}

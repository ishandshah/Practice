/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.tree;

// Time Complexity O(n) and Space Complexity O(h)
public class SymmetricTrees {

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(12);
        node.right=new TreeNode(12);
        node.left.left=new TreeNode(121);
        node.right.right=new TreeNode(121);
        node.left.right=new TreeNode(123);
        node.right.left=new TreeNode(123);
        System.out.println(isSymmetric(node));

    }

    public static boolean isSymmetric(TreeNode node){
        return node==null || checkSymmetric(node.left,node.right);
    }

    private static boolean checkSymmetric(TreeNode left, TreeNode right) {

        if(left==null && right==null)
            return true;

        else if(left!=null && right!=null && left.val== right.val){
            return checkSymmetric(left.left,right.right) &&  checkSymmetric(left.right,right.left) ;

        }

            return false;
    }
}

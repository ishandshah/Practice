/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.tree;

import java.util.LinkedList;

public class InvertTree {
    public TreeNode recursiveInvertTree(TreeNode root) {

        // Base case: if the tree is empty...
        if(root == null){
            return root;
        }
        // Call the function recursively for the left subtree...
        recursiveInvertTree(root.left);
        // Call the function recursively for the right subtree...
        recursiveInvertTree(root.right);
        // Swapping process...
        TreeNode curr = root.left;
        root.left = root.right;
        root.right = curr;
        return root;        // Return the root...

    }


    public  TreeNode iterativeInvertTree(TreeNode root){

        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        // Base case: if the tree is empty...
        if(root != null){
            // Push the root node...
            q.add(root);
        }
        // Loop till queue is empty...
        while(!q.isEmpty()){
            // Dequeue front node...
            TreeNode temp = q.poll();
            // Enqueue left child of the popped node...
            if(temp.left != null)
                q.add(temp.left);
            // Enqueue right child of the popped node
            if(temp.right != null)
                q.add(temp.right);
            // Swapping process...
            TreeNode curr = temp.left;
            temp.left = temp.right;
            temp.right = curr;
        }
        return root;

    }
}

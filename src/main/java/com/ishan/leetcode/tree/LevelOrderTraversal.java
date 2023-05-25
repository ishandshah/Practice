/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class LevelOrderTraversal {


        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> listList=new ArrayList<>();

            if(root==null)
                return new ArrayList<>();

            if(root!=null){
                listList.add(new ArrayList<>(){{
                    add(root.val);
                }});
            }
            Queue<TreeNode> nodeQueue=new LinkedList<>();
            nodeQueue.offer(root);

            while(!nodeQueue.isEmpty()){
                int levels = nodeQueue.size();
                List<Integer> childList=new ArrayList<>();

                for(int i=0;i<levels;i++){
                    if(nodeQueue.peek().left!=null){
                        //childList.add(nodeQueue.peek().left.val);
                        nodeQueue.offer(nodeQueue.peek().left);
                    }
                    if(nodeQueue.peek().left.right!=null){
                        //childList.add(poll.right.val);
                        nodeQueue.offer(nodeQueue.peek().left.right);
                    }
                    childList.add(nodeQueue.remove().val);
                }

                if(childList.size()>0){
                    listList.add(childList);
                }
            }


        return listList;
        }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().populateTree();
        List<List<Integer>> lists = new LevelOrderTraversal().levelOrder(treeNode);

        System.out.println(lists.size());
    }
}

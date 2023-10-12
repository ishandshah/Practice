/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.oct12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMaxPoints {

    public static int findMaxPoints(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxPoints = root.val;
        for (TreeNode child : root.children) {
            maxPoints = Math.max(maxPoints, root.val + findMaxPoints(child));
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        // Create the tree structure with multiple children per node
        TreeNode root = new TreeNode(1, Arrays.asList(
                new TreeNode(1, Arrays.asList(
                        new TreeNode(5),
                        new TreeNode(10)
                )),
                new TreeNode(3, Arrays.asList(
                        new TreeNode(7)
                ))
        ));


        // Find the maximum points
        int maxPoints = findMaxPoints(root);

        System.out.println("Maximum points: " + maxPoints);
    }
}

class TreeNode {
    int val;
    List<TreeNode> children;


    public TreeNode(int points) {
        this.val = points;
        this.children = new ArrayList<TreeNode>();
    }

    public TreeNode(int points, List<TreeNode> children) {
        this.val = points;
        this.children = children;
    }
}

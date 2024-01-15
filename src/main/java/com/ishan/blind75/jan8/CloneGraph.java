/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.jan8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Node copy=new Node(node.val);
        Node[] visited=new Node[101];
        Arrays.fill(visited,null);
        dfs(node,copy,visited);
        return copy;

    }

    public void dfs(Node node,Node copy,Node[] visited) {
        visited[copy.val]=copy;

        for(Node n:node.neighbors){

            if(visited[n.val]==null){
                Node newNode=new Node(n.val);
                copy.neighbors.add(newNode);
                dfs(n,newNode,visited);

            }else{
                //it's not null so the node was already visited and we don't need to do DFS over it, just add the node to COPY's neighbor list
                copy.neighbors.add(visited[n.val]);
            }

        }


    }


        class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

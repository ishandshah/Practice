/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.random;

import com.ishan.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Trie {


    static TrieNode root;

    // Driver
    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "theirs"};

        String[] output = {"Not present in trie", "Present in trie"};


        root = new TrieNode(' ');

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++)
            insert(keys[i]);

        // Search for different keys
        if (search("the"))
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if (search("these"))
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if (search("their"))
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if (search("thaw"))
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);


        System.out.println(suggest("the",100));
        System.out.println(suggest("there",100));
    }

    private static boolean search(String thaw) {
        TrieNode crawl = root;
        int index;
        for (int i = 0; i < thaw.length(); i++) {
            index = thaw.charAt(i) - 'a';

            if (crawl.children[index] == null)
                return false;

            crawl = crawl.children[index];
        }

        return crawl.isEndOfWord;
    }

    private static void insert(String word) {
        TrieNode crawl = root;

        //the
        int level;
        int length = word.length();
        int index;

        for (int i = 0; i < word.length(); i++) {

            index = word.charAt(i) - 'a';

            if (crawl.children[index] == null) {
                crawl.children[index] = new TrieNode(word.charAt(i));
            }
            crawl = crawl.children[index];
        }

        crawl.isEndOfWord = true;
    }
    private static List<String> suggest(String thaw, int suggestionLimit) {
        TrieNode crawl = root;
        int index;
        for (int i = 0; i < thaw.length(); i++) {
            index = thaw.charAt(i) - 'a';

            if (crawl.children[index] == null)
                return null;

            crawl = crawl.children[index];
        }
        List<String> suggestedWords=new ArrayList<>();
            // crawl

            if (crawl.children.length==0)
                return null;


            for(TrieNode child: crawl.children){
               // suggestionLimit--;
                if(child!=null)
                    suggestedWords.add(thaw + child.c);
            }

        return suggestedWords;
    }
    static class TrieNode {
        //ASCII characters
        int ALPHABET_SIZE = 128;
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        char c;
        TrieNode(char c) {
            isEndOfWord = false;
            this.c=c;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }
}



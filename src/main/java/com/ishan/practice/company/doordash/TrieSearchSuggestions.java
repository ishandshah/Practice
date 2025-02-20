/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


//TODO redo
public class TrieSearchSuggestions {


    public static void main(String[] args) {
        String[] products={"mobile","mouse","moneypot","monitor","mousepad"};
        String search="monitor";
        List<List<String>> lists = new TrieSearchSuggestions().suggestedProducts(products, search);
        System.out.println("hello");


    }
    static Trie root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        insertProducts(products);
     
        return suggestProduct(searchWord);
    }


    public List<List<String>> suggestProduct(String searchWord) {
        List<List<String>> suggested=new ArrayList<>();


        for(int i=0;i<searchWord.length();i++){

            List<String> searchResults=searchString(searchWord.substring(0,i+1));
            if(searchResults!=null && searchResults.size()>3){
                searchResults=concateLexicographically(searchResults);
            }
            suggested.add(searchResults);
        }

        return suggested;
    }

    private  List<String> concateLexicographically(List<String> searchResults) {
        return searchResults.stream().sorted(String::compareTo).limit(3).collect(Collectors.toList());
    }

    private List<String> searchString(String substring) {
        Trie lastNode = getLastNodeOf(substring);
        List<String> answer=new ArrayList<>();
        if (lastNode != null) {

            return collectSuggestions(lastNode, substring,answer);
        }

        return answer;
    }

    private List<String> collectSuggestions(Trie lastNode, String substring,List<String> answer) {

        if(lastNode.isEndOfWord){
            answer.add(substring);
        }

        for(int i=0;i<lastNode.children.length;i++){
            if(lastNode.children[i]!=null){
                collectSuggestions((lastNode.children[i]),substring+lastNode.children[i].currentChar,answer);
            }
        }
        return answer;
    }

    private Trie getLastNodeOf(String substring) {
        Trie curr=root;

        for(char c:substring.toCharArray()){
            int index=c -'a';

            if(curr!=null && curr.children[index]!=null){
                curr = curr.children[index];
            }else{
                return null;
            }
        }
        return curr;
    }


    public void insertProducts(String[] products){
        root=new Trie(' ');
        for(String product:products){
            insertIndividualProduct(product);
        }

    }


    public void insertIndividualProduct(String product){
        Trie crawl=root;

        for(int i=0;i<product.length();i++){

            int index=product.charAt(i)- 'a';
            if(crawl.children[index]==null)
                crawl.children[index]=new Trie(product.charAt(i));

            crawl=crawl.children[index];
        }


        crawl.isEndOfWord=true;


    }

    class Trie {
        int ALPHABET_SIZE = 128;
        char currentChar;
        boolean isEndOfWord;
        Trie[] children=new Trie[ALPHABET_SIZE];

        public Trie(char c) {

            currentChar = c;
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }



    }
}

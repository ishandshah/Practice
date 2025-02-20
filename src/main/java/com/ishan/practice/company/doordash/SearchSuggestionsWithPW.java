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
import java.util.PriorityQueue;

public class SearchSuggestionsWithPW {


        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            PriorityQueue<String> pq = new PriorityQueue<>(3, Comparator.naturalOrder());
            List<List<String>> list = new ArrayList<>();

            for(int i = 1; i<=searchWord.length(); i++){
                String temp = searchWord.substring(0, i);
                for(String s : products){
                    if(s.startsWith(temp)){
                        pq.offer(s);
                    }
                }
                List<String> temp_list = new ArrayList<>();
                for(int j = 0; j<3; j++){
                    if(pq.peek() != null){
                        temp_list.add(pq.poll());
                    }
                }
                pq.clear();
                list.add(temp_list);
            }
            return list;
        }
    }


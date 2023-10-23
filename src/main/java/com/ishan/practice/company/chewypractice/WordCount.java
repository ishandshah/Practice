/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.chewypractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) {

        List<String> sentenceList = List.of(" Ishan shah", " ishan majama", " shah kemnu",
                " jay shree krishna");


        calculateWordOccurence(sentenceList);

    }

    private static void calculateWordOccurence(List<String> sentenceList) {

        Map<String, Integer> wordCount = new HashMap<>();
        Map<String, List<Integer>> sentenceNoOccurenceMap = new HashMap<>();
        for (int i = 0; i < sentenceList.size(); i++) {
            String[] wordArray = sentenceList.get(i).split("\\s+");

            for (String word : wordArray) {
              /*  if(word==""){
                    continue;
                }*/

                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                    sentenceNoOccurenceMap.get(word).add(i);
                } else {
                    wordCount.put(word, 1);
                    List<Integer> arrList = new ArrayList<>();
                    arrList.add(i);
                    sentenceNoOccurenceMap.put(word, arrList);
                }
            }


        }
        System.out.println("sentenceNoOccurenceMap" + sentenceNoOccurenceMap.entrySet());
        System.out.println("wordCount" + wordCount.entrySet());
    }
}

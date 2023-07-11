/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.heap;

import java.util.*;

public class KFrequentNumbers {

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 2, 2, 3, 4, 5, 6, 1, 2, 2, 2, 6, 6, 6, 6, 6};
        int k = 2;
        findKFrequentUsingPQ(input, k);
        //only works for Single value based sort
        findKFrequentUsingTreeMap(input, k);

        findKFrequentUsingMap(input, k);
    }

    private static void findKFrequentUsingMap(int[] input, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : input) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);

        }
        // 1. Convert Map to List of Map
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<>(countMap.entrySet());

        Collections.sort(list,
                (o1, o2) -> o1.getValue() == o2.getValue() ?
                        Integer.compare(o2.getKey(), o1.getKey()) :
                        Integer.compare(o2.getValue(), o1.getValue()));

        for (int i = 0; i < k; i++) {
            System.out.print(list.get(i).getKey());
        }
        System.out.println();
    }

    private static void findKFrequentUsingTreeMap(int[] input, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : input) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);

        }

        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(
                new Comparator<>() {

                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                }
        );
        treeMap.putAll(countMap);
        //
        int i = 0;
        for (Map.Entry<Integer, Integer> hs : treeMap.entrySet()) {
            while (i < k) {
                System.out.print(hs.getKey());
                i++;
            }
            System.out.println();
            break;
        }
    }

    private static void findKFrequentUsingPQ(int[] input, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : input) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);

        }

        PriorityQueue<Map.Entry<Integer, Integer>> mapPriorityQueue = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(),
                        a.getKey()) : Integer.compare(b.getValue(),
                        a.getValue())
        );

        for (Map.Entry<Integer, Integer> entry :
                countMap.entrySet()) {
            mapPriorityQueue.offer(entry);
        }

        // Print the top k elements
        for (int i = 0; i < k; i++) {
            System.out.print(mapPriorityQueue.poll().getKey() + " ");
        }
        System.out.println();
    }
}

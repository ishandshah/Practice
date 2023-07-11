/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.practiceatlassian;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


/*

Design a ranked choice voting system.
A single person votes by handing in an ordered array of names
like : ["alice", "bob", "charlie", "dan"...]
Part 1 Candidates are given 3 points for 1st place, 2 points for 2nd and 1 point for 3rd place.
Given an array of arrays of names, return the candidates in order of most points to least.
Part 2 In the event of a tie, return the candidate who reached the winning points first
 */
public class RankedChoiceVoting {


    static Map<String, Integer> countMap = new HashMap<>();
    static int[] points = {3, 2, 1, 0};

    public static void main(String[] args) {
        String[][] votes = {
                {"alice", "bob", "charlie", "dan"},
                {"alice", "bob", "charlie", "dan"},
                {"alice", "bob", "charlie", "dan"},
                {"charlie", "bob", "alice", "dan"},
                {"bob", "dan", "charlie", "alice"},
                {"dan", "alice", "bob", "charlie"}
        };

        countPoints(votes);
    }

    private static void countPoints(String[][] votes) {
        var ref = new Object() {
            int max = 0;
            String personName;
        };

        for (String[] input : votes) {
            for (int i = 0; i < input.length; i++) {

                String name = input[i];

                int finalI = i;
                countMap.compute(name, (k, v) -> {

                    if (v != null) {
                        if (ref.max < v + points[finalI]) {
                            ref.max = v + points[finalI];
                            ref.personName = name;
                        }
                        return v + points[finalI];
                    } else {
                        if (ref.max < points[finalI]) {
                            ref.max = points[finalI];
                            ref.personName = name;
                        }
                        return points[finalI];
                    }
                });
            }

        }

        countMap.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                forEach(System.out::println);

        System.out.println(countMap.entrySet());
        System.out.println(ref.personName);
    }
}

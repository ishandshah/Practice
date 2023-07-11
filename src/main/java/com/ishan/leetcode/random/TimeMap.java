/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.random;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {

    private static final String DEFAULT_VALUE = "";
    private final HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> timeMap;
        if (map.containsKey(key)) {
            timeMap = map.get(key);
        } else {
            timeMap = new TreeMap<>();
            map.put(key, timeMap);
        }
        timeMap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer, String> timeMap = map.get(key);
            Integer floorKey = timeMap.floorKey(timestamp);
            if (floorKey != null) {
                return timeMap.get(floorKey);
            }
        }
        return DEFAULT_VALUE;
    }
}

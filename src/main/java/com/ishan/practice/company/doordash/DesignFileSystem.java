/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {
    class FileSystem {
        Map<String, Integer> file = new HashMap<>();

        public FileSystem() {
            file.put("", -1);
        }

        public boolean createPath(String path, int value) {
            int idx = path.lastIndexOf("/");
            String parent = path.substring(0, idx);
            if (!file.containsKey(parent)) { return false; }
            return file.putIfAbsent(path, value) == null;
        }

        public int get(String path) {
            return file.getOrDefault(path, -1);
        }
    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */

}

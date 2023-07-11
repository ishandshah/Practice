/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.random;

import java.util.*;

public class SocialMediaMap {
    public static List<List<String>> findLevels(Map<String, List<String>> personMap, String person) {
        List<List<String>> levels = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
      
        queue.add(new Pair(person,0));
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            String currentPerson=poll.getPersonName();
            int level=poll.getLevel();
            if (!visited.contains(currentPerson)) {
                visited.add(currentPerson);

                // Add current person to the corresponding level list
                if (level >= levels.size()) {
                    levels.add(new ArrayList<>(Arrays.asList(currentPerson)));
                } else {
                    levels.get(level).add(currentPerson);
                }

                List<String> friends = personMap.getOrDefault(currentPerson, Collections.emptyList());
                for (String friend : friends) {
                    queue.add(new Pair(friend, level + 1));
                }

            }

        }

            return levels;
    }
    public static void main(String[] args) {
        // Example social media map
        Map<String, List<String>> personMap = new HashMap<>();
        personMap.put("Alice", Arrays.asList("Bob", "Charlie"));
        personMap.put("Bob", Arrays.asList("David", "Eve"));
        personMap.put("Charlie", Arrays.asList("Frank"));
        personMap.put("David", Collections.emptyList());
        personMap.put("Eve", Arrays.asList("Grace", "Hank"));
        personMap.put("Frank", Arrays.asList("Ivy"));
        personMap.put("Grace", Collections.emptyList());
        personMap.put("Hank", Collections.emptyList());
        personMap.put("Ivy", Collections.emptyList());
        personMap.put("Ishan", Collections.emptyList());

        // Find all levels of connections for a given person
        String person = "Alice";
        List<List<String>> levels = findLevels(personMap, person);

        // Print the levels
        for (int i = 0; i < levels.size(); i++) {
            System.out.println("Level " + i + ": " + levels.get(i));
        }
    }

    private static class Pair {
        String personName;
        int level;

        public Pair(String personName, int level) {
            this.personName = personName;
            this.level = level;
        }

        public String getPersonName() {
            return personName;
        }


        public int getLevel() {
            return level;
        }

    }
}

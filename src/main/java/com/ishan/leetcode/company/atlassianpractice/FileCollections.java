/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice;

import java.util.*;

class Collection {
    String name;
    long size;
    List<Collection> subCollections;

    public Collection(String name, long size) {
        this.name = name;
        this.size = size;
        this.subCollections = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Collection{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", subCollections=" + subCollections +
                '}';
    }
}

public class FileCollections {

    static long totalSize = 0l;

    public static void main(String[] args) {

        String[] fileNames = {"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"};
        String[] collectionNames = {"Collection1", "Collection2.Collection2a", "Collection2", "Collection3", "Collection3"};
        long[] fileSizes = {100, 200, 150, 300, 250};

        // Build the collection hierarchy
        Map<String, Collection> collections = buildCollections(fileNames, collectionNames, fileSizes);
        // Calculate the total size of all files in the system
        System.out.println(getTotalSize());


        // Find the top N collections by size
        int topN = 2;
        List<Collection> topCollections = findTopCollections(collections, topN);
        System.out.println(Arrays.toString(topCollections.stream().toArray()));
    }

    private static List<Collection> findTopCollections(Map<String, Collection> collections, int topN) {
        List<Collection> allCollections = new ArrayList<>(collections.values());

        allCollections.sort((c1, c2) -> Long.compare(c2.size, c1.size));
        return allCollections.subList(0, Math.min(topN, allCollections.size()));

    }

    private static Map<String, Collection> buildCollections(String[] fileNames, String[] collectionNames, long[] fileSizes) {

        Map<String, Collection> collectionMap = new HashMap<>();

        // assuming  collectionNames & fileNames will be of same length
        for (int i = 0; i < fileNames.length; i++) {


            int finalI = i;
            totalSize += fileSizes[finalI];

            //collection.size += fileSizes[finalI];
          collectionMap.compute(collectionNames[i], (k, collection) -> {


                        if (collection == null) {
                            Collection collectionInst = new Collection(collectionNames[finalI], fileSizes[finalI]);
                            return collectionInst;
                        } else {

                            collection.size += fileSizes[finalI];
                        }

                        return collection;
                    }
            );
        }
        return collectionMap;
    }


    static long getTotalSize() {
        return totalSize;
    }
}

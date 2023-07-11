/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

//Todo Sort a Map of String and class by an integer value inside the class
public class CalculateSize {

    static long total=0l;
    static List<File> fileList=new ArrayList<>();

    static Map<File,LocalClass> fileLongMap=new HashMap<>();
    static long MEGABYTE = 1024L * 1024L;
    public static void main(String[] args) {
        String directoryPath = "/Users/ishanshah/Downloads";
        long totalSize = calculateDirectorySize(directoryPath);
        System.out.println("Total size of files in directory: " + totalSize + "mega bytes");
     //   Collections.sort(fileList);
       // System.out.println(fileList);


       // fileLongMap.entrySet().stream().sorted((Comparator<? super Map.Entry<File, LocalClass>>) Map.Entry.comparingByValue()).forEach(System.out::println);;
        //System.out.println(fileLongMap.entrySet());
        //LocalClassComparator lcs=new LocalClassComparator();

        List<Map.Entry<File, LocalClass>> sortedEntries = sortMapByValue(fileLongMap);

        // Iterate over sorted entries
        for (Map.Entry<File, LocalClass> entry : sortedEntries) {
            String key = entry.getKey().getName();
            LocalClass value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value.getSize());
        }
     //   Collections.sort(fileList,lcs);
    }

    private static List<Map.Entry<File, LocalClass>> sortMapByValue(Map<File, LocalClass> map) {


        List<Map.Entry<File, LocalClass>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, new Comparator<>() {
            @Override
            public int compare(Map.Entry<File, LocalClass> entry1, Map.Entry<File, LocalClass> entry2) {
                long value1 = entry1.getValue().getSize();
                long value2 = entry2.getValue().getSize();
                return Long.compare(value1, value2);
            }
        });
        return entries;

    }

    private static long calculateDirectorySize(String directoryPath) {

        File directory = new File(directoryPath);
        if(!directory.exists()|| !directory.isDirectory()){
                return total;
        }

        File[] files=directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if(file.isFile()) {
                    fileList.add(file);

                    long l = file.length() / MEGABYTE;
                    fileLongMap.put(file,new LocalClass(l));
                    total += l;
                }else{
                    calculateDirectorySize(file.getAbsolutePath());

                }
            }

        }

        return total;

    }
}

/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan;


import java.util.HashMap;
import java.util.Map;

/*
// You can edit this code!
// Click here and start typing.
package main

import (
	"fmt"
)

func main() {
	fmt.Println(words("fox is a test of a few words a test only the quick brown fox jumps over the fox fox"))

	// Func words() should return all unique words (single space separated) in any order and the most common
	// word (any of them if several are equally common).
	// Func should return slice of strings and a string
	// Example output from above example: [of only the quick jumps a is test few words brown over fox] fox
}

func words(s string) ([]string, string) {
	// Add code here
}

 */
public class Illumio {
    static Map<String, Integer> wordCount = new HashMap<>();


    static String maxFrequencyWord = "";
    static int maxFrequencyCount = 0;


    public static void main(String[] args) {
        String input = "fox is a test of a few words a test only the quick brown fox jumps over the fox fox";

        process(input);

        //maxFrequencyCount, maxFrequencyWord
    }


    private static void process(String inputData) {

        String[] strings = inputData.split("\\s+");
        for (String inputWord : strings) {
            int updatedCount;
            if (wordCount.containsKey(inputWord)) {
                updatedCount = wordCount.get(inputWord) + 1;
            } else {
                updatedCount = 1;
            }
            if (updatedCount > maxFrequencyCount) {
                maxFrequencyCount = updatedCount;
                maxFrequencyWord = inputWord;
            }
            wordCount.put(inputWord, updatedCount);
        }

        System.out.println(wordCount.keySet() + "," + maxFrequencyWord);

    }

    /*
    *
    *
    * create table users (n int,  name text);
create table data (n int,  label text);

select * from users;
 n | name
---+------
 1 | joe
 2 | bob
 3 | charlie
(3 rows)

select * from data;
 n | label
---+-----
 3 | baz
 2 | bar
 1 | foo
(3 rows)

Retrieve all name from users where the corresponding label in data (same n) starts with 'b'
*
*  Select u.name from users u JOIN data d ON u.n=d.n where d.label like 'b%';
*
    *
    *
    *
    *
    * */
}
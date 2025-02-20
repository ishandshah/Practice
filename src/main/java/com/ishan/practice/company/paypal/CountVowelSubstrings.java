/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.paypal;


import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/count-vowel-substrings-of-a-string/solutions/1563906/java-brute-force-hashset-8ms-easy-to-understand/?envType=company&envId=paypal&favoriteSlug=paypal-thirty-days&role=all
public class CountVowelSubstrings {
    public int countVowelSubstrings(String word) {
        int vow = 0;
        int n = word.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n - 4; i++) {
            set.clear();
            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);

                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {


                    set.add(ch);
                    if (set.size() == 5) {
                        vow++;
                    }
                } else {
                    break;
                }
            }
        }
        return vow;

    }

}

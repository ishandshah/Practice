/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.October.oct16;

//https://leetcode.com/problems/ransom-note/
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        char[] magaine = magazine.toCharArray();
        for (Character c : magaine) {
            int x = c - 'a';
            count[x]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int x = ransomNote.charAt(i) - 'a';
            if (count[x] <= 0) {
                System.out.println(false);
                return false;
            } else {
                count[x]--;
            }
        }

        return true;


    }
}

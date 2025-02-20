/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;

public class MinStepsAnagram {

    public int minSteps(String s, String t) {
        int[] count=new int[26];

        for(int i=0;i<s.length();i++){
        char c1=s.charAt(i);
        count[c1-'a']++;
        char c2=t.charAt(i);
        count[c2-'a']--;
        }
        int minSteps=0;
        for(int i:count){
            minSteps+=Math.abs(i);
        }
        return minSteps/2;
    }

    public static void main(String[] args) {
        String s1="bab";
        String s2="aba";

        System.out.println(new MinStepsAnagram().minSteps(s1,s2));
    }
}

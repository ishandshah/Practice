/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.paypal;


// https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/description/?envType=company&envId=paypal&favoriteSlug=paypal-three-months
public class RearrangeString {

    public int secondsToRemoveOccurrences(String s) {
        int seconds = 0;
        boolean changed = true;

        while(changed){
            changed=false;

            for(int i=0;i<s.length()-1 ; i++){
                if(s.charAt(i) == '0' && s.charAt(i+1)=='1'){
                        StringBuilder s1 = new StringBuilder(s);
                        s1.setCharAt(i,'1');
                        s1.setCharAt(i+1,'0');
                        s=s1.toString();
                        i++;

                         changed=true;

                }


            }
            System.out.println(s);
            if (changed)
                seconds++;


        }

        return seconds;
    }


    public int secondsToRemoveOccurrencesBetter(String s) {
        int seconds = 0;
        while (s.indexOf("01") >= 0) {
            s = s.replace("01", "10");
            ++seconds;
        }
        return seconds;
    }

    public static void main(String[] args) {
        int i = new RearrangeString().secondsToRemoveOccurrences("0110101");
        System.out.println(i);
    }

}

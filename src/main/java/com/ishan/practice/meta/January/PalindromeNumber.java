/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.meta.January;

//https://leetcode.com/problems/palindrome-number/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }
        if(x>=0 && x<=9){
            return true;
        }
        int originalNum=x;
        int y=0;
        while(x!=0){
            int rema=x%10;
            y=y*10 + rema;
            x=x/10;
        }


        return y==originalNum;
    }

    public static void main(String[] args) {
        PalindromeNumber pf=new PalindromeNumber();

        System.out.println(pf.isPalindrome(10));


    }

}

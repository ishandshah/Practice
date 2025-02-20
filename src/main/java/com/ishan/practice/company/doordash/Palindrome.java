/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.doordash;


//Can string be converted into a palindrome by removing atmost 1 character
public class Palindrome {




    public static void main(String[] args) {


        String input="abcbad";
          // Brute force
        //System.out.println(canGeneratePalindrome(input));


        System.out.println(canBePalindromeByRemovingOneChar(input));
    }

    private static boolean canBePalindromeByRemovingOneChar(String input) {


        int left=0;
        int right=input.length()-1;

        while(left<right){
            if(input.charAt(left)!=input.charAt(right)){
                return isPalindrome(input,left+1,right) || isPalindrome(input,left,right-1);
            }
            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    private static boolean canGeneratePalindrome(String input) {

        if(isPalindrome(input.substring(1,input.length()))){
            return true;
        }
        for(int i=1;i<input.length();i++){

            String s = input.substring(0, i) + input.substring(i + 1, input.length());
            if(isPalindrome(s)){
                System.out.println( s);
                return true;
            }

        }

        return false;
    }

    private static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equalsIgnoreCase(s);

    }


}

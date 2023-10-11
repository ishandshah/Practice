/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.bill;

public class CompressDecompressString {


    public static void main(String[] args) {
        String input="ishanaaabbccddde";


        String compressedString=compress(input);
        System.out.println(compressedString);

        decompress(compressedString);
    }

    private static void decompress(String compressed) {

        StringBuilder decompressed=new StringBuilder();

        int i = 0;

        while (i < compressed.length()) {
            char character = compressed.charAt(i);
            i++; // Move to the next character

            int count = 0;
            while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                count = count * 10 + (compressed.charAt(i) - '0');
                i++; // Move to the next digit
            }

            for (int j = 0; j < count; j++) {
                decompressed.append(character);
            }
        }

        System.out.println(decompressed.toString());
    }

    private static String compress(String input) {
        if(input==null|| input.length()<2 ){
            return input;
        }
        int j=0;
        StringBuilder sb=new StringBuilder();
        int count=1;
        for(int i=1;i<input.length();i++){

            if(input.charAt(j) == input.charAt(i)){
                  count++;

            }else{

                sb.append(input.charAt(j));
                sb.append(count);
                j=i;
                count=1;
            }
        }


            sb.append(input.charAt(j));
            sb.append(count);


        return sb.toString();
    }
}

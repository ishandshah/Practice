/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.generics;

public class GenericMethod {
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++)
            if (x.equals(y[i])) return true;
        return false;

        //return  false;
    }

    public static void main(String[] args) {

        // Use isIn() on Integers.
        Integer[] nums = {1, 2, 3, 4, 5};
        if (isIn(2, nums))
            System.out.println("2 is in nums");
        if (!isIn(7, nums))
            System.out.println("7 is not in nums");
        System.out.println();
// Use isIn() on Strings.
        String[] strs = {"one", "two", "three",
                "four", "five"};
        if (isIn("two", strs))
            System.out.println("two is in strs");
        if (!isIn("seven", strs))
            System.out.println("seven is not in strs");
// Oops! Won't compile! Types must be compatible.
// if(isIn("two", nums))
// System.out.println("two is in strs");
    }


}

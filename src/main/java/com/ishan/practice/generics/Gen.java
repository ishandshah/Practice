/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.generics;

public class Gen<T> {

    // A simple generic class.
// Here, T is a type parameter that
// will be replaced by a real type
// when an object of type Gen is created.

    T ob; // declare an object of type T

    // Pass the constructor a reference to
// an object of type T.
    Gen(T o) {
        ob = o;
    }

    // Return ob.
    T getOb() {
        return ob;
    }

    // Show type of T.
    void showType() {
        System.out.println("Type of T is " +
                ob.getClass().getName());
    }
}

// Demonstrate the generic class.
class GenDemo {
    public static void main(String[] args) {
// Create a Gen reference for Integers.
        Gen<Integer> iOb;
// Create a Gen<Integer> object and assign its
// reference to iOb. Notice the use of autoboxing
// to encapsulate the value 88 within an Integer object.
        iOb = new Gen<Integer>(88);
// Show the type of data used by iOb.
        iOb.showType();
// Get the value in iOb. Notice that
// no cast is needed.
        int v = iOb.getOb();
        System.out.println("value: " + v);
        System.out.println();
// Create a Gen object for Strings.
        Gen<Object> gen1 = new Gen<>(5);

        System.out.println("value: on" + gen1.getClass());
        System.out.println("value: on " + gen1.getOb());
        Gen<Long> longOb = new Gen<>(88L);
        longOb.showType();
// Get the value of strOb. Again, notice
// that no cast is needed.
        //Long str2 = longOb.getOb().getClass();
        System.out.println("value: " + longOb.getOb().getClass());
        Gen<String> strOb = new Gen<String>("88");
// Show the type of data used by strOb.
        strOb.showType();
// Get the value of strOb. Again, notice
// that no cast is needed.
        String str = strOb.getOb();
        System.out.println("value: " + str);
    }
}

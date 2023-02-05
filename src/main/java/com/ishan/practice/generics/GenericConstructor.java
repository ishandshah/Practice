/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.generics;

public class GenericConstructor {


    private final double x;

    <T extends Number> GenericConstructor(T value) {
        this.x = value.doubleValue();
    }

    void showval() {
        System.out.println("val: " + x);
    }

}


class GenConsDemo {
    public static void main(String[] args) {
        GenericConstructor test = new GenericConstructor(-100);
        GenericConstructor test2 = new GenericConstructor(123.5F);
        GenericConstructor test3 = new GenericConstructor(123123123123123123123123123123123123.5F);
        test.showval();
        test2.showval();
    }
}

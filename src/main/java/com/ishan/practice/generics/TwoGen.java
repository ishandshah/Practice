/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.generics;

public class TwoGen<K, V> {

    K ob1;
    V ob2;
    private TwoGen<K, V> obj;

    TwoGen(K o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    public static void main(String[] args) {
        Gen<String> s1 = new Gen<>("ishan");
        TwoGen<String, Gen<String>> ishan = new TwoGen<>("ishan", s1);
        System.out.println(ishan.getOb1().getClass());
        System.out.println(ishan.getOb1());


        System.out.println(ishan.getOb2().getClass());
        System.out.println(ishan.getOb2().getOb());
    }

    public TwoGen<K, V> getObj() {
        return obj;
    }

    public K getOb1() {
        return ob1;
    }

    public V getOb2() {
        return ob2;
    }


}

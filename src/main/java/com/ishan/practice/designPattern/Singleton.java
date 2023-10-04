/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.designPattern;

public class Singleton implements Cloneable {

    private volatile static Singleton singleton;

    private Singleton() throws Exception {
        if (singleton != null) {
            System.out.println(("Singleton already created"));
        }
    }

    public static void main(String[] args) throws Exception {
        Singleton singleton = new Singleton();
        singleton.getSingleton();
        Singleton singleton1 = new Singleton();
        Singleton singleton2 = (Singleton) singleton1.clone();
        System.out.println(singleton2);
    }

    public Singleton getSingleton() throws Exception {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }

    @Override
    public Object clone() {
        System.out.println(("Singleton already created"));
        try {
            return this.getSingleton();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.chewypractice;

//todo think on why static block isn't good for such use cases
public class SynchronizedSingleton {

    SynchronizedSingleton synchronizedSingleton;

    private SynchronizedSingleton() {
        if (synchronizedSingleton != null) {
            System.out.println(("Singleton already created"));
        }
    }


    public SynchronizedSingleton getSynchronizedSingleton() {
        if (synchronizedSingleton == null) {
            synchronized (SynchronizedSingleton.class) {
                synchronizedSingleton = new SynchronizedSingleton();
            }
        }
        return synchronizedSingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getSynchronizedSingleton();
    }
}

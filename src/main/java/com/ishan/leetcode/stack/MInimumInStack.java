/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.stack;

import java.util.Stack;

public class MInimumInStack {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();


        st.push(1);
        st.push(11);
        st.push(12);
        st.push(13);
        st.push(14);
        int minimuValue = Integer.MAX_VALUE;

        while (!st.isEmpty()) {

            if (st.peek() < minimuValue) {
                Integer peek = st.peek();
                minimuValue = peek;

            }
            st.pop();
        }
        System.out.println("minimuValue" + minimuValue);
    }
}

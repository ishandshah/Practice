/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.lamda;

// An example of capturing a local variable from the enclosing scope.
interface MyFunc {
    int func(int n);
}

//todo
public class VarCapture {
    public static void main(String[] args) {
        // A local variable that can be captured.
        int num = 10;
        MyFunc myLambda = (n) -> {
// This use of num is OK. It does not modify num.
            //        int v = num + n;
// However, the following is illegal because it attempts
// to modify the value of num.
            //   num++;
            //return v;

            return -1;
        };
//// The following line would also cause an error, because
//// it would remove the effectively final status from num.
        num = 9;
    }
}
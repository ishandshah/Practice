/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.lamda;

import java.security.PrivilegedAction;
import java.util.HashSet;
import java.util.Set;

public class Test {
    static MyNumber myNum;
    static NumericTest numericTest;

    static NumericTest2 numericTest2;
    public static void main(String[] args) {
        //new Runa
        // Use a lambda in an assignment context.

        // Default value
        myNum = () -> 123.45;
        if(false) {
            System.out.println(myNum.getValue());
        }
        // Single paramter
        numericTest= (n)->n % 3 == 0;
        if(false) {
            if (numericTest.test(12)) System.out.println("10 is even");
            if (!numericTest.test(10)) System.out.println("9 is not even");
// Now, use a lambda expression that tests if a number
// is non-negative.
            NumericTest isNonNeg = (n) -> n >= 0;
            if (isNonNeg.test(1)) System.out.println("1 is non-negative");
            if (!isNonNeg.test(-1)) System.out.println("-1 is negative");

        }

        // 2 parameter
        numericTest2=(x,y)-> x / y!=0 && x%y==0;

        if(numericTest2.test(10,5)){
            System.out.println("ALOHA");
        }
        Set<String> hashSet2=new HashSet<>(){{
          add("ishan");
          add("shah");
          add("ishani");
        }};

        String is="ishan";
        TwoParameterSetString twoParameterSetString=(hashSet,x)-> hashSet.contains(x);
        System.out.println(twoParameterSetString.test(hashSet2,is));
    }
}

interface MyNumber {
    double getValue();

}


interface NumericTest {

    // Integer input boolean output
    // like x % 2 ==0 or x > 1000
    boolean test(int n);
}

// Demonstrate a lambda expression that takes two parameters.
interface NumericTest2 {

    boolean test(int n, int d);
}


interface TwoParameterSetString{

    boolean test(Set<String> hashSet, String s1);
}
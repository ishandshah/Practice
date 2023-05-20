/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.lamda;

//TODO Uncomment line on 19 and 20 and 35
// Book Java 8 , line 394 (429 of 1313)
public class ExceptionLambda {
    public static void main(String[] args) throws EmptyArrayException
    {
        double[] values = { 1.0, 2.0, 3.0, 4.0 };
// This block lambda computes the average of an array of doubles.
        DoubleNumericArrayFunc average = (n) -> {
            double sum = 0;
//            if(n.length == 0)
//                throw new EmptyArrayException();
            for(int i=0; i < n.length; i++)
                sum += n[i];
            return sum / n.length;
        };
        System.out.println("The average is " + average.func(values));
// This causes an exception to be thrown.
        System.out.println("The average is " + average.func(new double[0]));
    }
}


interface DoubleNumericArrayFunc{

    double func(double[] input) ;
    // throws EmptyArrayException
}

class EmptyArrayException extends Exception {
    EmptyArrayException() {
        super("Array Empty");
    }
}
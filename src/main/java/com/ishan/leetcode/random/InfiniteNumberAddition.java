package com.ishan.leetcode.random;

import java.math.BigInteger;

public class InfiniteNumberAddition {

    public static void main(String[] args) {
        String num1 = "1234567890123456789011112345678901234567890111123456789012345678901111234567890123456789011112345678901234567890111";
        String num2 = "987654321098765432101234567890123456789011112345678901234567890111123456789012345678901111234567890123456789011112345678901234567890111";

        BigInteger result = add(num1, num2);
        System.out.println("Sum: " + result);
    }

    private static BigInteger add(String num1, String num2) {

        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);

        //BigInteger sum=b1.add(b2);

        return b1.add(b2);
    }


}

/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.jan15;

public class BinaryTree {

        static double root(double x, int n) {
            // your code goes here
            // 27.00, 3

            double lowerBound=0.0;
            if(x >= 1.0){
                lowerBound=1.0;
            }

            double upperBound = x/n;
            System.out.println("upperBound" + upperBound);
            while(lowerBound<upperBound){
                double mid=lowerBound +(upperBound-lowerBound)/2;

                double rootMiddle=findValue(mid,n);
                System.out.println("Mid value is" + mid + " rootMiddle" + rootMiddle);
                if(rootMiddle==x || (rootMiddle-x < 0.001 && rootMiddle-x >0) || (x-rootMiddle<0.001 &&  x-rootMiddle >0)){
                    return mid;
                }else if(rootMiddle < x){
                    lowerBound=mid;
                }else{
                    upperBound=mid;
                }

            }
            return lowerBound;
        }

        public static double findValue(double mid,int n){

            double answer=1.0;
            for(int i=0;i<n;i++){
                answer*=mid;
            }
            //
            return answer;
        }

        public static void main(String[] args) {

            System.out.println(new BinaryTree().root(7.00,3));

        }

    }


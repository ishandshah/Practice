/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.random;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeAndLadderGame {

    private Map<Integer, Integer> ladderMap;
    private Map<Integer, Integer> snakeMap;


    public SnakeAndLadderGame(){


        ladderMap=new HashMap<>(){{
            put(3,22);
            put(5,8);
            put(11,26);
            put(20,29);
        }};


        snakeMap=new HashMap<>(){{
            put(27,1);
            put(17,4);
            put(21,9);
            put(19,7);
        }};
    }
    public boolean isLadder(int i){
         return ladderMap.containsKey(i);
    }

    public boolean isSnake(int i){
        return snakeMap.containsKey(i);
    }


    public void stepsTaken(){



      //  int answer=30;
        int currentStep=0;
        int stepsTaken=0;
        while(currentStep!=30){


            int dice=new Random().nextInt(1,6);
            currentStep+=dice;
            if(currentStep>30){
                currentStep-=dice;
                continue;
            }
            if(isLadder(currentStep)){
                currentStep=ladderMap.get(currentStep);
                System.out.println("Ladder from " + dice + " to " + currentStep );
            }else if (isSnake(currentStep)){
                System.out.println("Snake from " + dice + " to " + currentStep );
                currentStep=snakeMap.get(currentStep);
            }
            stepsTaken++;
        }

        System.out.println(stepsTaken);
    }

    public static void main(String[] args) {
        SnakeAndLadderGame skg=new SnakeAndLadderGame();
        skg.stepsTaken();
    }
}

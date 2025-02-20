/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 *//*


package com.ishan.practice.company.doordash;

public class Question {
}

// To find all the stores that are open in a user’s delivery radius, we need to check the store’s operating hours.
// We currently store this information in Elasticsearch but the query performance for our use-case is turning out to be
// not very efficient. The format that we store it in Elasticsearch is something like this:

// {
//   "store": {
//     "store_name": "Tasty Pizzas",
//     "store_id": "123345",
//     "operating_hours": [
//       {
//         "hours.open": "mon 10:00 am",
//         "hours.close": "mon 2:00 pm"
//       },
//       {
//         "hours.open": "tue 10:00 am",
//         "hours.close": "tue 2:00 pm"
//       },
//       {
//         "hours.open": "wed 10:00 am",
//         "hours.close": "wed 2:00 pm"
//       },
//       {
//         "hours.open": "thu 10:00 am",
//         "hours.close": "thu 2:00 pm"
//       },
//       {
//         "hours.open": "fri 10:00 am",
//         "hours.close": "fri 2:00 pm"
//       },
//       {
//         "hours.open": "sat 10:00 am",
//         "hours.close": "sat 2:00 pm"
//       }
//     ]
//   }
// }
// We want to experiment with improving the performance of fetching open stores by converting the operating hours into encoded tokens.
// These would be of fixed length of five.

// The first digit would represent the day, Monday maps to number 1, Tuesday to 2 and so on.
// The next four digits would represent the hours in 24 hours format.

// Examples:

// Monday, 10:00am transforms to 11000
// Monday, 2:00pm transforms to 11400 (as 2pm -> 14:00 in 24 hr format)

// Write a function that takes in a start_time and end_time and returns a list of all encoded tokens of in that range at 5 minute intervals.
// Ensure you validate the input.

// Ex: Input: ("mon 10:00 am", "mon 11:00 am")
// Output: [“11000”, “11005”, “11010”, “11015”, “11020”, “11025”, “11030”, “11035”, “11040”, “11045”, “11050”, “11055”, “11100”]

// Input: ("mon 10:15 am", "mon 11:00 am")
// Output: [“11015”, “11020”, “11025”, “11030”, “11035”, “11040”, “11045”, “11050”, “11055”, “11100”]

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class Solution {

    public static Map<String,String> dayOfTheWeek=new HashMap<>(){{
        put("mon","1");
        put("tue","2");
        //    put("wed",3);
        //    put("thu",4);
        //    put("fri",5);
        //    put("sat",6);
        //    put("sun",7);
    }};
    public static List<String> getEncodedTimings(String startTime, String endTime){

        // addChecksToRolloverIfNeeded


        // ("mon 10:15 am", "mon 11:00 am")

        String[] startTimeStrings=startTime.split("\\s+");

        String[] endTimeStrings=endTime.split("\\s+");

        if(startTimeStrings.length!=3 || endTimeStrings.length!=3){
            return new ArrayList<>();
        }
        // Add check to not do this for 12 PM
        //1100 2200
        String startTimeEncoded=getHourOfTheDay(startTimeStrings);
        String endTimeEncoded=getHourOfTheDay(endTimeStrings);

        // 1100 2200
        return getOperatingTimes(startTimeStrings[0],endTimeStrings[0],startTimeEncoded,endTimeEncoded);
    }

    public static List<String> getOperatingTimes(String startDay, String endDay, String startTimeEncoded, String endTimeEncoded){
        List<String> answerList=new ArrayList<>();

        Integer startDayTime= Integer.parseInt(dayOfTheWeek.get(startDay) + startTimeEncoded);
        Integer endDayTime= Integer.parseInt(dayOfTheWeek.get(endDay) + endTimeEncoded); // 2
        // 11000 11100
        // 12
        Integer currentTime=startDayTime;
        answerList.add(String.valueOf(currentTime));
        while(currentTime<endDayTime){
            // 1155
            if(currentTime% 100==55){
                currentTime+=45;
                // 12:00
            }else{
                currentTime+=5;
            }

            answerList.add(String.valueOf(currentTime));
        }



        return answerList;
    }

    public static String getHourOfTheDay(String[] timeArray){
        // 10:00
        String hourArraySplit[]=timeArray[1].split(":");
        System.out.println(timeArray[2]);
        if(timeArray[2].equals("pm")){
            System.out.println("hourBy24String");
            int hourBy24=Integer.parseInt(hourArraySplit[0]) + 12;
            String hourBy24String=String.valueOf(hourBy24) + hourArraySplit[1];

            return hourBy24String;}
        else{
            return new String(hourArraySplit[0] + hourArraySplit[1]);}




    }

    public static void main(String[] args) {
        List<String> outputList=getEncodedTimings("mon 10:15 am", "mon 11:00 pm");
        System.out.println(outputList.size());

        A : 10,15,25,32,35,-,-,-
                B : 7,16,31

        A : 7,10, 15,16,30,31,35


// A: 7,15,25,30,35,_,_,_
// B : 10,16,31




        A - > B - > C - > D - > E -> null

        A - > B - > D - > E

        curr=c

        // C
        Node curr;

        if(curr.next.next!=null){

            curr.data=curr.next.data;
            curr=curr.next.next;
        }


        curr.data=curr.next.data;
        curr.next=null;







 public Node{

            Node curr;
            char data;
        }





        for(String outString:outputList){
            System.out.println(outString);
        }
    }
}



​​Input: strs = ["eat","tea","tan","ate",”listen”,"nat","silent"]
        Output: [["silent",”listen”],["nat","tan"],["ate","eat","tea"]]


        boolean[] visited=new boolean[strs.length];
        List<String> answerList=new ArrayList<>();
        for(int i=0;i<strs.length;i++){

        List<String> subList=new ArrayList<>();


        char[] charArray1=Arrays.sort(strs[i].toCharArray());

        if(visited[i]){

        continue;
        }


        for(int j=i+1;j<strs.length;j++){

        if(visited[j]){

        continue;
        }else{

        Char[] charArray2=Arrays.sort(strs[j].toCharArray());
        if(charArray2==charArray1){
        visited[j]=true;

        subList.add(strs[j]);

        }

        }

        visited[i]=true;
        answerList.addAll(subList);
        subList=new ArreayList<>();



        }

        }



        }

        }






















        "cat", "dog", "tac", "god", "act"
        catcat", "dog", "tac", "god", "act"
        ", "dog",”cat"cat", "dog", "tac", "god", "act"
        "tac", "god

// How does the resolver happens from the /endpoint to controller
// Different kind of auth mechanism that I've worked on
// 6570, find largest possible number
// Locking mechanism for RDS
*/

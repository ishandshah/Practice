/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.blind75.October.oct10;

import java.util.Arrays;
import java.util.Comparator;

/*
 *Given an array of meeting time
 * intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...](si< ei), determine if a person could attend all meetings.
 * */
public class MeetingRooms {

    public static void main(String[] args) {
        int[][] meetingTimes2 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] meetingTimes = {{7, 10}, {2, 4}};
        // {{7,10},{2,4}}


        Arrays.sort(meetingTimes, Comparator.comparingInt(o -> o[0]));
        boolean canAttend = true;

        int endingTime = meetingTimes[0][1];
        for (int i = 1; i < meetingTimes.length; i++) {
            if (meetingTimes[i][0] < endingTime) {
                canAttend = false;
                break;
            } else {
                endingTime = meetingTimes[i][1];
            }
        }

        System.out.println("Can Attend all meetings :" + canAttend);
    }
}

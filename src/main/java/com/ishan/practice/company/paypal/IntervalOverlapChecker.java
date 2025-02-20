/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.paypal;
import java.util.Arrays;
import java.util.Comparator;

public class IntervalOverlapChecker {

    // Class to represent an interval with start and end times
    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // Function to check if any intervals overlap
    public static boolean hasOverlap(Interval[] intervals) {
        // Sort the intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        // Check for overlap by comparing current interval with previous one
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return true; // Overlap found
            }
        }

        return false; // No overlap found
    }

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1, 5),
                new Interval(6, 10),
                new Interval(4, 8),  // Overlapping with the first interval
                new Interval(11, 13)
        };

        if (hasOverlap(intervals)) {
            System.out.println("There is an overlap between the intervals.");
        } else {
            System.out.println("No overlap between the intervals.");
        }
    }
}

